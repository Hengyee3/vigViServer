/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author JiaYunTeo
 */
@Entity
public class Transaction implements Serializable {

    


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @OneToOne(mappedBy = "transaction")
    private CustomerSession customerSession;
    private Date createdDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date merchantReceivedDate;
    private double customerAmount;
    private boolean merchantReceivedStatus;
    private double merchantAmount;
    private double platformAmount;
//    private Date deactivatedDate;
    
    @PrePersist
    protected void onCreate() {
        setCreatedDate(new Date());
    }

    @PreUpdate
    protected void onUpdate() {
        setUpdatedDate(new Date());
    }
    
    
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Transaction() {
    }

    public Transaction(double customerAmount, boolean merchantReceivedStatus, double merchantAmount, double platformAmount) {
        this.customerAmount = customerAmount;
        this.merchantReceivedStatus = merchantReceivedStatus;
        this.merchantAmount = merchantAmount;
        this.platformAmount = platformAmount;
    }
    

    
    
    public CustomerSession getCustomerSession() {
        return customerSession;
    }

    public void setCustomerSession(CustomerSession customerSession) {
        this.customerSession = customerSession;
    }
    
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    
    public Date getMerchantReceivedDate() {
        return merchantReceivedDate;
    }

    public void setMerchantReceivedDate(Date merchantReceivedDate) {
        this.merchantReceivedDate = merchantReceivedDate;
    }

    public double getCustomerAmount() {
        return customerAmount;
    }

    public void setCustomerAmount(double customerAmount) {
        this.customerAmount = customerAmount;
    }

    public boolean isMerchantReceivedStatus() {
        return merchantReceivedStatus;
    }

    public void setMerchantReceivedStatus(boolean merchantReceivedStatus) {
        this.merchantReceivedStatus = merchantReceivedStatus;
    }

    public double getMerchantAmount() {
        return merchantAmount;
    }

    public void setMerchantAmount(double merchantAmount) {
        this.merchantAmount = merchantAmount;
    }

    public double getPlatformAmount() {
        return platformAmount;
    }

    public void setPlatformAmount(double platformAmount) {
        this.platformAmount = platformAmount;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the transactionId fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Transaction[ id=" + transactionId + " ]";
    }
    
}
