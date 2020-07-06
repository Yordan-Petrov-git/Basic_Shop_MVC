package com.shop.advance.academy.yordan.petrov.git.shop.domain.models;

import com.shop.advance.academy.yordan.petrov.git.shop.data.entities.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class TransactionServiceViewModel {

    Long id;
    private String number;
    private CardServiceViewModel recipient;
    private CardServiceViewModel sender;
    private String description;
    private Instant dateCreated;
    private Instant dateCompleted;
    private Instant dateUpdated;
    private TransactionStatus transactionStatus = TransactionStatus.NEW;
    private Long fee;
    private BigDecimal amount;
    private CurrencyServiceViewModel currency;

    public TransactionServiceViewModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CardServiceViewModel getRecipient() {
        return this.recipient;
    }

    public void setRecipient(CardServiceViewModel recipient) {
        this.recipient = recipient;
    }

    public CardServiceViewModel getSender() {
        return this.sender;
    }

    public void setSender(CardServiceViewModel sender) {
        this.sender = sender;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Instant getDateCompleted() {
        return this.dateCompleted;
    }

    public void setDateCompleted(Instant dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Instant getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(Instant dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public TransactionStatus getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Long getFee() {
        return this.fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyServiceViewModel getCurrency() {
        return this.currency;
    }

    public void setCurrency(CurrencyServiceViewModel currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionServiceViewModel)) return false;
        TransactionServiceViewModel that = (TransactionServiceViewModel) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(dateCompleted, that.dateCompleted) &&
                Objects.equals(dateUpdated, that.dateUpdated) &&
                transactionStatus == that.transactionStatus &&
                Objects.equals(fee, that.fee) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, description, dateCreated, dateCompleted, dateUpdated, transactionStatus, fee, amount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransactionServiceViewModel{");
        sb.append("number='").append(number).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", dateCompleted=").append(dateCompleted);
        sb.append(", dateUpdated=").append(dateUpdated);
        sb.append(", transactionStatus=").append(transactionStatus);
        sb.append(", fee=").append(fee);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}