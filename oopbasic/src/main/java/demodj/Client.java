package demodj;

public class Client {
    AbstractDAO dao;
    public Client() {
        dao = FactoryDAO.getDAO();
    }
    public AbstractDAO getDao() {
        return FactoryDAO.getDAO();
    }
    public void setDao(AbstractDAO dao) {
        this.dao = dao;
    }

    public void execute() {
        dao.insert();
        dao.update();
        dao.delete();
    }
}