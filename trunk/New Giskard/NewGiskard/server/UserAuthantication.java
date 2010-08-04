package com.wissen.NewGiskard.server;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wissen.NewGiskard.server.domainObjects.LoginDetails;
import com.wissen.NewGiskard.server.hibernate.HibernateUtill;

public class UserAuthantication {

    /**
     * Description:- Method For Authantication Of User From Database.
     */

    public LoginDetails AuthUser(String userName, String password) {

        HibernateUtill hibernateUtill = new HibernateUtill();

        Session session = hibernateUtill.getSession();

        Query userAuthanticationQuery = session
                .createQuery("from LoginDetails GiskardLoginData where GiskardLoginData.userName = :userName and GiskardLoginData.password = :password");
        userAuthanticationQuery.setParameter("userName", userName);
        userAuthanticationQuery.setParameter("password", password);
        LoginDetails GiskardLoginData = (LoginDetails) userAuthanticationQuery.uniqueResult();

        return GiskardLoginData;

    }

}