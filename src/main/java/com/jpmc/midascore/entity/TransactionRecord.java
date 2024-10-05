package com.jpmc.midascore.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue()
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserRecord sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserRecord recipient;

    @Column(nullable = false)
    private float amount;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(nullable = false)
    private Date updatedAt;

    protected TransactionRecord() {}

    public TransactionRecord(UserRecord sender, UserRecord recipient, float amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public UserRecord getSender() { return sender; }
    public void setSender(UserRecord sender) { this.sender = sender; }

    public UserRecord getRecipient() { return recipient; }
    public void setRecipient(UserRecord recipient) { this.recipient = recipient; }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    @Override
    public String toString() {
        return String.format("Transaction[id=%d]: Sender[id=%d], Recipient[id=%d], Amount=[%.2f]", id, sender.getId(), recipient.getId(), amount);
    }
}
