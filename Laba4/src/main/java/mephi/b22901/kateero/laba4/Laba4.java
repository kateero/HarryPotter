package mephi.b22901.kateero.laba4;

import GUI.GalaFrame;

public class Laba4 {

    public static void main(String[] args) {
        GalaFrame gf = new GalaFrame();
        gf.setLocationRelativeTo(null);
        gf.setVisible(true);

        /*
        try {
            // Начало транзакции
            em.getTransaction().begin();

            // Создание нового волшебника
            Wizard wizard = new Wizard();
            wizard.setFirstName("Гарри");
            wizard.setLastName("Поттер");

            // Сохранение в БД
            em.persist(wizard);

            // Коммит транзакции
            em.getTransaction().commit();
            
        } catch (Exception e) {
            // Откат в случае ошибки
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Закрытие ресурсов
            em.close();
            emf.close();
        }
    
         */
    }
}
