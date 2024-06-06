import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OperationsSurEmployes {
    public static void main(String[] args) {
        // Création de la liste d'employés
        List<Employe> employes = new ArrayList<>();
        employes.add(new Employe("Alice", "R&D", 50000));
        employes.add(new Employe("Bob", "Finance", 60000));
        employes.add(new Employe("Charlie", "Ventes", 55000));
        employes.add(new Employe("David", "Ressources humaines", 48000));
        employes.add(new Employe("Eve", "Marketing", 52000));

        // 1. Calculer la somme totale des salaires de tous les employés
        double sommeSalaires = employes.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires : " + sommeSalaires);

        // 2. Trier la liste des employés par ordre alphabétique du nom
        employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .forEach(System.out::println);

        // 3. Trouver l'employé avec le salaire le plus bas
        Employe employeSalaireMinimum = employes.stream()
                .min(Comparator.comparing(Employe::getSalaire))
                .orElse(null);
        System.out.println("Employé avec le salaire le plus bas : " + employeSalaireMinimum);

        // 4. Obtenir la liste des employés ayant un salaire supérieur à une valeur donnée
        double salaireMinimum = 55000;
        List<Employe> employesSalairesSup = employes.stream()
                .filter(employe -> employe.getSalaire() > salaireMinimum)
                .toList();
        System.out.println("Employés avec un salaire supérieur à " + salaireMinimum + " : " + employesSalairesSup);

        // 5. Trouver l'employé avec le salaire le plus élevé dans l'ensemble de l'entreprise
        Employe employeSalaireMaximum = employes.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2)
                .orElse(null);
        System.out.println("Employé avec le salaire le plus élevé : " + employeSalaireMaximum);

        // 6. Concaténer les noms de tous les employés
        String nomsConcatenes = employes.stream()
                .map(Employe::getNom)
                .reduce("", (nom1, nom2) -> nom1 + ", " + nom2);
        System.out.println("Noms de tous les employés : " + nomsConcatenes);
    }
}

