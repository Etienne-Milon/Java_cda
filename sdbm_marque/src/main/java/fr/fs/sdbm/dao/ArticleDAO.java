package fr.fs.sdbm.dao;

import fr.fs.sdbm.metier.*;
import fr.fs.sdbm.service.ArticleSearch;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ArticleDAO extends DAO<Article,ArticleSearch>
{
    public ArticleDAO(Connection connexion) {super(connexion);}

    public ArrayList<Article> getLike(ArticleSearch articleSearch)
    {
        ResultSet rs;
        ArrayList<Article> liste = new ArrayList<>();
        String procedureStockee = "{call dbo.sp_QBE_Vue_Article (?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee))
        {
            cStmt.setString(1,articleSearch.getLibelle());
            cStmt.setInt(2,articleSearch.getVolume());
            cStmt.setDouble(3,articleSearch.getTitrageMin());
            cStmt.setDouble(4,articleSearch.getTitrageMax());
            cStmt.setInt(5,articleSearch.getMarque().getId());
            cStmt.setInt(6,articleSearch.getFabricant().getId());
            cStmt.setString(7,articleSearch.getPays().getId());
            cStmt.setInt(8,articleSearch.getContinent().getId());
            cStmt.setInt(9,articleSearch.getCouleur().getId());
            cStmt.setInt(10,articleSearch.getType().getId());



            // pagination 11,12...

            cStmt.execute();
            rs = cStmt.getResultSet();

            while (rs.next())
            {
                // création d'un nouvel article à partir d'une ligne du resultset
                Article newArticle = new Article();
                newArticle.setId(rs.getInt(1));
                newArticle.setLibelle(rs.getString(2));
                newArticle.setPrixAchat(rs.getFloat(3));
                newArticle.setVolume(rs.getInt(4));
                newArticle.setTitrage(rs.getFloat(5));
                newArticle.setMarque(new Marque());
                newArticle.getMarque().setId(rs.getInt(6));
                newArticle.getMarque().setLibelle(rs.getString(7));
                newArticle.getMarque().setFabricant(new Fabricant());
                newArticle.getMarque().getFabricant().setId(rs.getInt(8));
                newArticle.getMarque().getFabricant().setLibelle(rs.getString(9));
                newArticle.getMarque().setPays(new Pays());
                newArticle.getMarque().getPays().setId(rs.getString(10));
                newArticle.getMarque().getPays().setLibelle(rs.getString(11));
                newArticle.getMarque().getPays().setContinent(new Continent());
                newArticle.getMarque().getPays().getContinent().setId(rs.getInt(12));
                newArticle.getMarque().getPays().getContinent().setLibelle(rs.getString(13));
                newArticle.setCouleur(new Couleur(rs.getInt(14),rs.getString(15)));
                newArticle.setTypeBiere(new TypeBiere(rs.getInt(16),rs.getString(17)));
                liste.add(newArticle);
            }
            rs.close();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public Article getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Article> getAll() {
        return null;
    }
    @Override
    public boolean insert(Article objet) {
        return false;
    }

    @Override
    public boolean update(Article object) {
        return false;
    }

    @Override
    public boolean delete(Article object) {
        return false;
    }

}
