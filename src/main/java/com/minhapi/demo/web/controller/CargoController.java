package com.minhapi.demo.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.minhapi.demo.domain.Cargo;
import com.minhapi.demo.domain.Departamento;
import com.minhapi.demo.service.CargoService;
import com.minhapi.demo.service.DepartamentoService;
import com.minhapi.demo.util.PaginacaoUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private DepartamentoService departamentoService;
    @Autowired
    private CargoService cargoService;
    
    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "cargo/cadastro";
    }
    
    @GetMapping("/listar")
    public String listar(ModelMap model, 
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("dir") Optional<String> dir) {

        int paginaAtual = page.orElse(1);
        String direcao = dir.orElse("asc");

        PaginacaoUtil<Cargo> pageCargo = cargoService.buscaPorPagina(paginaAtual, direcao);

        model.addAttribute("pageCargo", pageCargo);
        return "cargo/lista";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "cargo/cadastro";
        }

        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo salvo com sucesso");
        return "redirect:/cargos/cadastrar";
    }
      
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }
      
    @PostMapping("/editar")
    public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "cargo/cadastro";
        }
    
        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso");
        return "redirect:/cargos/listar";
    }

    @ModelAttribute("departamentos") 
    public List<Departamento> listaDeDepartamentos() {
        return departamentoService.buscarPorTodos();
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (cargoService.cargoTemFuncionario(id)) {
            attr.addFlashAttribute("error", "Cargo não excluido. O cargo possui funcionario(s) vinculado(s)");
        } else {
            cargoService.excluir(id);
            attr.addFlashAttribute("success", "Cargo excluido com sucesso");
        }
        return "redirect:/cargos/listar";
    }
      

}
