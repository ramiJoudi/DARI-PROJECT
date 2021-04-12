package VORTEX.DARIPROJECT.ENTITY;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    private String  nom ;

    private Date dateDep;

    private String description ;
   
    private String  location;

    private float area ;

    private  float prix ;
 
    private int roomNb ;
    private  String Image ;
    private boolean parckingPlace ;

    @Enumerated(EnumType.STRING)
    private Type type ;


    @ManyToOne
    private User user;
    


    public Annonce() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDep() {
        return dateDep;
    }

    public void setDateDep(Date dateDep) {
        this.dateDep = dateDep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getRoomNb() {
        return roomNb;
    }

    public void setRoomNb(int roomNb) {
        this.roomNb = roomNb;
    }

    public boolean isParckingPlace() {
        return parckingPlace;
    }

    public void setParckingPlace(boolean parckingPlace) {
        this.parckingPlace = parckingPlace;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Annonce(String nom, Date dateDep, String description, String location, float area, float prix, int roomNb, boolean parckingPlace, Type type, User user) {
        this.nom = nom;
        this.dateDep = dateDep;
        this.description = description;
        this.location = location;
        this.area = area;
        this.prix = prix;
        this.roomNb = roomNb;
        this.parckingPlace = parckingPlace;
        this.type = type;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateDep=" + dateDep +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", prix=" + prix +
                ", roomNb=" + roomNb +
                ", parckingPlace=" + parckingPlace +
                ", type=" + type +
                '}';
    }
}
