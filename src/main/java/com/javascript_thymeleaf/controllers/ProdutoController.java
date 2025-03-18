package com.javascript_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javascript_thymeleaf.models.Produto;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProdutoController {

    // Método para exibir a página inicial com os produtos
    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        // Simulando uma lista de produtos
        List<Produto> produtos = gerarProdutos(0, 10); // Carregar os primeiros 10 produtos
        model.addAttribute("produtos", produtos);
        return "produto/listar"; // Nome do template Thymeleaf
    }

    // Método para carregar mais produtos (AJAX)
    @GetMapping("/produtos/adicionar")
    public String carregarMaisProdutos(@RequestParam int inicio, Model model) {
        List<Produto> produtos = gerarProdutos(inicio, 10);
        model.addAttribute("produtos", produtos);
        return "produto/produtosFragment :: produtosFragment";
    }


    // Método para gerar produtos simulados
    private List<Produto> gerarProdutos(int inicio, int quantidade) {
        List<Produto> produtos = new ArrayList<>();
        for (int i = inicio; i < inicio + quantidade; i++) {
            produtos.add(new Produto((long) i, "Produto " + (i + 1), Math.random() * 100));
        }
        return produtos;
    }
}