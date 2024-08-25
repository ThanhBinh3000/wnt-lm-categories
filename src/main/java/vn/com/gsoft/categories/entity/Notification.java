package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Notification")
@Entity
public class Notification extends BaseEntity{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "DrugStoreID")
    private String drugStoreId;
    @Column(name = "Title")
    private String title;
    @Column(name = "Link")
    private String link;
    @Column(name = "NotificationTypeID")
    private int notificationTypeID;
    @Column(name = "Status")
    private int status;
    @Column(name = "Contents")
    private String contents;
    @Column(name = "ResourceID")
    private int resourceID;
    @Column(name = "StoreId")
    private int storeId;
    @Column(name = "CreateDate")
    private Date createDate;
    @Transient
    private String createDateTxt;
}
