import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;

/**
 * Write a description of class ScoreLoad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreLoad extends Actor
{
    private ArrayList<String> listaMelhores = new ArrayList<String>(); //lista que guardara as pontuações por ordem decrescente de pontuação
    /**
     * Act - do whatever the ScoreLoad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * 
     */
    public ScoreLoad()
    {
        GreenfootImage imagem = getImage();
        imagem.clear();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("records.txt")); //criação do objeto reader que permitirá aceder aos dados presentes no ficheiro "records.txt"
            
            String linha = null; //onde vamos guardar o que é retirado do ficheiro onde estão guardados os recordes
            while((linha=reader.readLine())!=null)  //enquanto for diferente de false quer dizer que ha ainda dados para ler e guarda-o na variavel string e também já processa o que foi recebido
                processaDados(linha);
        }catch(IOException ex)
        {
            System.out.println("No records yet!"); //se nao existir o ficheiro esta exception é "catched"
        }
    }
    
    /**
     * processaDados(String)- processa os dados obtidos pela leitura do ficheiro "records.txt". Nomeadamente adiciona à listaMelhores a pontuação,
     * mas nao adiciona de qualquer maneira, adiciona de forma decrescente, ou seja a maior pontuação fica na posição 0 da lista.
     */
    private void processaDados(String recordes)
    {
        if(listaMelhores.isEmpty()) //se a lista estiver vazia adicionamos simplesmente na lista sem ser preciso fazer qualquer comparação
                listaMelhores.add(recordes);
        else
        {
            for(int i = 0, n = listaMelhores.size(); i < n ; i++) //vamos incrementando i até encontrarmos uma posicao em que o valor do array seja maior ou igual ao da lista ou até chegarmos à ulima posicao da lista onde fazemos a comparação final
            {
                if(Integer.parseInt(listaMelhores.get(i))<=Integer.parseInt(recordes)) //se o que está na lista for menor que proximo elemento "recordes", entao guardamos nessa posicao da lista
                {        
                    listaMelhores.add(i,recordes);
                    break;
                }
                else if(i==n-1) //se ja tivermos no ultimo caso e o que estiver na lista for maior que o elemento "recordes", entao metemos na ultima posicao
                        listaMelhores.add(recordes);
            }
        }
    }
    
    /**
     * getList() - retorna a lista que contém as pontuações ordenadas por ordem decrescente
     */
    protected List getList()
    {
        return listaMelhores;
    } 
}