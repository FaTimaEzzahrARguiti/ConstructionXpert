package Controllers;

import DAO.TacheDAO;
import Model.Tache;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tache")
public class TacheServlet extends HttpServlet {
    private TacheDAO tacheDao;

    @Override
    public void init() throws ServletException {
        tacheDao = new TacheDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "listtache";  // Action par défaut si null
        }
        switch (action) {
            case "newtache":
                showNewForm(req, resp);
                break;
            case "neweditform":
                try {
                    showEditForm(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "createtache":
                ajoutTache(req, resp);
                break;
            case "listtache":
                listTache(req, resp);
                break;
            case "updatetache":
                try {
                    updateTache(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deletetache":
                supprimerTache(req, resp);
                break;
            default:
                listTache(req, resp);
                break;
        }
    }

    private void updateTache(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id_tache"));
        String nom = request.getParameter("nom");
        String dateDebut = request.getParameter("date_debut");
        String dateFin = request.getParameter("date_fin");
        int idProjet = Integer.parseInt(request.getParameter("id_projet"));

        System.out.println("Tentative de mise à jour - ID: " + id + ", Nom: " + nom +
                ", DateDébut: " + dateDebut + ", DateFin: " + dateFin + ", Projet ID: " + idProjet);

        Tache tache = new Tache(id, nom, dateDebut, dateFin, idProjet);
        tacheDao.updateTache(tache);
        System.out.println("Tâche mise à jour avec ID : " + id);
        response.sendRedirect(request.getContextPath() + "/tache?action=listtache");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_tache"));
        Tache existingTache = tacheDao.getTache(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listtache.jsp");
        request.setAttribute("tache", existingTache);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("listtache.jsp");
        dispatcher.forward(request, response);
    }

    public void ajoutTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String dateDebut = req.getParameter("date_debut");
        String dateFin = req.getParameter("date_fin");
        int idProjet = Integer.parseInt(req.getParameter("id_projet"));

        Tache tache = new Tache(nom, dateDebut, dateFin);
        tache.setId_projet(idProjet);
        tacheDao.insertTache(tache);
        System.out.println("Nouvelle tâche ajoutée avec Projet ID : " + idProjet);
        resp.sendRedirect(req.getContextPath() + "/tache?action=listtache");
    }

    public void listTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tache> taches = tacheDao.getAllTaches();
        req.setAttribute("taches", taches);
        System.out.println("Liste des tâches récupérée : " + taches.size() + " tâches");
        RequestDispatcher dispatcher = req.getRequestDispatcher("listtache.jsp");
        dispatcher.forward(req, resp);
    }

    public void supprimerTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        tacheDao.deleteTache(id);
        System.out.println("Tâche supprimée avec ID : " + id);
        resp.sendRedirect(req.getContextPath() + "/tache?action=listtache");
    }
}