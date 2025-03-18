<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar et Tableau Responsive - ConstructionXpert</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        /* Reset CSS */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            padding-top: 80px; /* Pour éviter que la navbar ne chevauche le contenu */
        }

        /* Styles de la navbar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            padding: 1rem 2rem;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }

        .logo {
            display: flex;
            align-items: center;
            color: #fff;
            font-size: 1.5rem;
        }

        .logo i {
            margin-right: 10px;
            font-size: 2rem;
            color: #f39c12; /* Couleur orange pour l'icône */
        }

        .nav-links {
            display: flex;
            list-style: none;
        }

        .nav-links li {
            margin-left: 2rem;
        }

        .nav-links a {
            color: #fff;
            text-decoration: none;
            font-size: 1.1rem;
            transition: color 0.3s ease;
        }

        .nav-links a:hover {
            color: #f39c12;
        }

        .nav-links i {
            margin-right: 0.5rem;
        }

        .burger {
            display: none;
            cursor: pointer;
        }

        .burger div {
            width: 25px;
            height: 3px;
            background-color: #fff;
            margin: 5px;
            transition: all 0.3s ease;
        }

        /* Animation pour le burger */
        .toggle .line1 {
            transform: rotate(-45deg) translate(-5px, 6px);
        }

        .toggle .line2 {
            opacity: 0;
        }

        .toggle .line3 {
            transform: rotate(45deg) translate(-5px, -6px);
        }

        /* Responsive Design pour la navbar */
        @media screen and (max-width: 768px) {
            .nav-links {
                position: absolute;
                right: 0;
                height: 100vh;
                top: 8vh;
                background-color: #333;
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 50%;
                transform: translateX(100%);
                transition: transform 0.5s ease-in;
            }

            .nav-links li {
                opacity: 0;
            }

            .burger {
                display: block;
            }
        }

        .nav-active {
            transform: translateX(0%);
        }

        @keyframes navLinkFade {
            from {
                opacity: 0;
                transform: translateX(50px);
            }
            to {
                opacity: 1;
                transform: translateX(0px);
            }
        }

        /* Styles du tableau */
        .table-container {
            padding: 2rem;
            overflow-x: auto; /* Pour permettre le défilement horizontal sur les petits écrans */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #333;
            color: #fff;
            font-weight: bold;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        /* Couleurs similaires à la navbar */
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* Bouton Ajouter un projet */
        .add-project-button {
            display: inline-block;
            margin: 1rem 2rem;
            padding: 10px 20px;
            background-color: #f39c12;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
            transition: background-color 0.3s ease;
        }

        .add-project-button:hover {
            background-color: #e67e22;
        }

        .add-project-button i {
            margin-right: 8px;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <div class="logo">
        <i class="fas fa-building"></i> <!-- Icône Font Awesome pour le logo -->
        <span>ConstructionXpert</span> <!-- Texte à côté de l'icône -->
    </div>
    <ul class="nav-links">
        <li><a href="#"><i class="fas fa-home"></i> Accueil</a></li>
        <li><a href="#"><i class="fas fa-building"></i> Projets</a></li>
        <li><a href="#"><i class="fas fa-tools"></i> Services</a></li>
        <li><a href="#"><i class="fas fa-users"></i> Équipe</a></li>
        <li><a href="#"><i class="fas fa-chart-line"></i> Tableau de Bord</a></li>
    </ul>
    <div class="burger">
        <div class="line1"></div>
        <div class="line2"></div>
        <div class="line3"></div>
    </div>
</nav>

<!-- Contenu principal avec le tableau -->
<div class="table-container">
    <!-- Bouton Ajouter un projet -->
    <a ><button class="add-project-button" data-bs-toggle="modal" data-bs-target="#addProjectModal" onclick="openModal()">
        <i class="fas fa-plus"></i> Ajouter un projet
    </button></a>

    <!-- Tableau -->
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Projet</th>
            <th>Responsable</th>
            <th>Date de début</th>
            <th>Statut</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>Construction immeuble A</td>
            <td>Jean Dupont</td>
            <td>2023-10-01</td>
            <td>En cours</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Rénovation pont B</td>
            <td>Marie Curie</td>
            <td>2023-09-15</td>
            <td>Terminé</td>
        </tr>
        <tr>
            <td>3</td>
            <td>Construction route C</td>
            <td>Pierre Martin</td>
            <td>2023-11-01</td>
            <td>Planifié</td>
        </tr>
        <tr>
            <td>4</td>
            <td>Installation éclairage D</td>
            <td>Sophie Lambert</td>
            <td>2023-10-20</td>
            <td>En cours</td>
        </tr>
        </tbody>
    </table>
</div>

<!-- Modal Bootstrap pour ajouter un projet -->
<div class="modal fade" id="addProjectModal" tabindex="-1" aria-labelledby="addProjectModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addProjectModalLabel">Ajouter un projet</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="projectForm">
                    <div class="mb-3">
                        <label for="projectName" class="form-label">Nom du projet</label>
                        <input type="text" class="form-control" id="projectName" required>
                    </div>
                    <div class="mb-3">
                        <label for="projectManager" class="form-label">Responsable</label>
                        <input type="text" class="form-control" id="projectManager" required>
                    </div>
                    <div class="mb-3">
                        <label for="projectStartDate" class="form-label">Date de début</label>
                        <input type="date" class="form-control" id="projectStartDate" required>
                    </div>
                    <div class="mb-3">
                        <label for="projectDescription" class="form-label">Description</label>
                        <textarea class="form-control" id="projectDescription" rows="3" required></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                <button type="submit" form="projectForm" class="btn btn-primary">Enregistrer</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS et dépendances -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<script>
    const navSlide = () => {
        const burger = document.querySelector('.burger');
        const nav = document.querySelector('.nav-links');
        const navLinks = document.querySelectorAll('.nav-links li');

        burger.addEventListener('click', () => {
            // Toggle Nav
            nav.classList.toggle('nav-active');

            // Animate Links
            navLinks.forEach((link, index) => {
                if (link.style.animation) {
                    link.style.animation = '';
                } else {
                    link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 0.3}s`;
                }
            });

            // Burger Animation
            burger.classList.toggle('toggle');
        });
    }

    navSlide();

    // Gestion du formulaire
    document.getElementById('projectForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const projectName = document.getElementById('projectName').value;
        const projectManager = document.getElementById('projectManager').value;
        const projectStartDate = document.getElementById('projectStartDate').value;
        const projectDescription = document.getElementById('projectDescription').value;

        if (projectName && projectManager && projectStartDate && projectDescription) {
            alert("Projet enregistré avec succès !");
            // Fermer la modal
            const modal = bootstrap.Modal.getInstance(document.getElementById('addProjectModal'));
            modal.hide();
        } else {
            alert("Veuillez remplir tous les champs.");
        }
    });
</script>
</body>
</html>