<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, Model.Tache" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Tâches</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Liste des Tâches</h1>
<a href="<%=request.getContextPath()%>/tache?action=newtache" class="btn btn-primary">Ajouter Tâche</a>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Date Début</th>
        <th>Date Fin</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Tache> taches = (List<Tache>) request.getAttribute("taches");
        if (taches != null) {
            for (Tache tache : taches) {
    %>
    <tr>
        <td><%= tache.getId_tache() %></td>
        <td><%= tache.getNom() %></td>
        <td><%= tache.getDate_debut() %></td>
        <td><%= tache.getDate_fin() %></td>
        <td>
            <a href="<%=request.getContextPath()%>/tache?action=neweditform&id_tache=<%=tache.getId_tache()%>" class="btn btn-warning">Modifier</a>
            <a href="<%=request.getContextPath()%>/tache?action=deletetache&id=<%=tache.getId_tache()%>" class="btn btn-danger" onclick="return confirm('Confirmer la suppression ?')">Supprimer</a>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>