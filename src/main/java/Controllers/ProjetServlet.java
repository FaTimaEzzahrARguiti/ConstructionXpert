package Controllers;

import DAO.ProjetDAO;
import Model.Projet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/projet/*")
public class ProjetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjetDAO projetDAO;

    public ProjetServlet() {
        projetDAO = new ProjetDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response); // Redirige les requêtes POST vers doGet
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo(); // Extrait l'action de l'URL

        System.out.println("Action: " + action);

        if (action == null || action.equals("/")) {
            action = "list"; // Action par défaut
        } else {
            action = action.substring(1); // Supprime le slash initial
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertProjet(request, response);
                    break;
                case "delete":
                    deleteProjet(request, response);
                    break;
                case "edit":

                    break;
                case "update":
                    updateProjet(request, response);
                    break;
                default:
                    listProjets(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException("Erreur de base de données : " + e.getMessage(), e);
        }
    }

    // Liste tous les projets
    private void listProjets(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Projet> listProjets = projetDAO.selectAllProjets();
        request.setAttribute("listProjets", listProjets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    // Affiche le formulaire pour ajouter un nouveau projet
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ProjetForm.jsp");
        dispatcher.forward(request, response);
    }

    // Affiche le formulaire pour modifier un projet existant

    // Insère un nouveau projet
    private void insertProjet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        System.out.println("//////////"+request.getParameter("date_debut"));
        LocalDate date_debut = LocalDate.parse(request.getParameter("date_debut"));
        System.out.println("//////////"+date_debut.toString());

        LocalDate date_fin = LocalDate.parse(request.getParameter("date_fin"));

        int budget= Integer.parseInt(request.getParameter("budget"));
        Projet newProjet = new Projet(nom, description, date_debut, date_fin, budget);
        projetDAO.AddProjet(newProjet);
        response.sendRedirect("list");
    }

    // Met à jour un projet existant
    private void updateProjet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
      //  Date dateDebut = Date.valueOf(request.getParameter("date_debut"));
       // Date dateFin = Date.valueOf(request.getParameter("date_fin"));

        int budget= Integer.parseInt(request.getParameter("budget"));;
      //  Projet projet = new Projet(id, nom, description, dateDebut, dateFin, budget);
       // projetDAO.updateProjet(projet); // Note : Vous devrez ajouter cette méthode dans ProjetDAO
        response.sendRedirect("list");
    }

    // Supprime un projet
    private void deleteProjet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        projetDAO.deleteProjet(id); // Note : Vous devrez ajouter cette méthode dans ProjetDAO
        response.sendRedirect("list");
    }
}