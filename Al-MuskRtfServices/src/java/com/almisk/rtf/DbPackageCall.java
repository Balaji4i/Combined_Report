/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almisk.rtf;

import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author gautham.r
 */
public class DbPackageCall {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public void dbInitialization() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                //            connection = DriverManager.getConnection("jdbc:oracle:thin:@144.21.66.200:1521/fmpdb1.593077064.oraclecloud.internal", "XXPL", "welcome123");
//              connection = DriverManager.getConnection("jdbc:oracle:thin:@130.61.216.253:1521/almprod1.almisksubnet2.almiskvcn.oraclevcn.com", "XXPL", "xX9L_A1m_sk");
           connection = getConnectionDS("PL");
            } catch (NamingException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static Connection getConnectionDS(String datasource) throws SQLException,
            NamingException {
        Connection con = null;
        DataSource data = null;
        Context initialContext = new InitialContext();
        if (initialContext == null) {


        }
        data = (DataSource) initialContext.lookup(datasource);
        if (data != null) {
            con = data.getConnection();
        } else {
            System.out.println("Failed to Find JDBC DataSource.");
        }
        return con;
    }

    public String offerXml(String offerNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_offer_form('" + offerNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String bookingXml(String bookingNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_booking_form('" + bookingNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String bookingReceiptXml(String receiptNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_bookingreceipt_form('" + receiptNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String provisionalBookingXml(String bookingNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_provisional_bk_receipt('" + bookingNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String recommendationReceiptXml(String receiptNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_recommendreceipt_form('" + receiptNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String provisionalReceiptXml(String recomendationNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_provisional_rec_receipt('" + recomendationNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String recomendationXml(String recomendationNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_reservation_form('" + recomendationNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String sharjahXml(String leaseNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_tc_sharjah_form('" + leaseNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public String dubaiXml(String leaseNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_tc_dubai_form('" + leaseNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
     public String taxInvoiceXml(String leaseNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_tax_invoice('" + leaseNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
public String recomendationReceiptAckXml(String recomendationNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.xxpm_provisional_rec_ack('" + recomendationNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
}
//finally {
//            try {
//                //dbDestroy();
//            } catch (SQLException ex) {
//                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
//            }
            return xmlString;
        
    }
//individual
public String OC_Recommendation_Line_Receiptxml(String receiptNumber) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_recommendreceipt_form_oc('" + receiptNumber + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

// summary
public String OC_Recommendation_Receiptxml(String OtherChargesNo) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_provisional_rec_receip_oc('" + OtherChargesNo + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }	
// ack  Xxpm_provisional_rec_ack_oc
public String OC_Recommendation_Receipt_Ackxml(String OtherChargesNo) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_provisional_rec_ack_oc('" + OtherChargesNo + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
        }
// ack  Xxpm_provisional_rec_ack_oc
public String Booking_Receipt_Ackxml(String BookingNo) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.Xxpm_provisional_book_ack('" + BookingNo + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
        }
// CN for proposed(status - Proposed) and final(status - final)
public String cancellation_propo_final_xml_CN(String cancellationNo) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.XXPM_CANCELLATION_REPORT('" + cancellationNo + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
        }
// CN for proposed history (status - Final)
public String cancellation_propo_H_xml_CN(String cancellationNo) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.XXPM_PROPOSED_CANCELLATION_REPORT('" + cancellationNo + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
        }
//OC tax invoice
public String OcTaxInvoiceXml(String oc_no) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxpm_report_pkg.xxpm_tax_invoice_almisk_bu('" + oc_no + "')xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }

    public void dbDestroy() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }

}
