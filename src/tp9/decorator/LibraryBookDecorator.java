package tp9.decorator;
import tp9.Book;

import java.time.LocalDate;

// Décorateur pour ajouter des fonctionnalités de bibliothèque
public class LibraryBookDecorator implements BookDecorator {
    private Book book;
    private boolean isLoaned;
    private LocalDate dueDate;

    public LibraryBookDecorator(Book book) {
        this.book = book;
        this.isLoaned = false;
        this.dueDate = null;
    }

    // définit un prêt. isLoaned de vient vrai, et on fournit la date du prêt
    public void loanOut(LocalDate dueDate) {
        this.isLoaned = true;
        this.dueDate = dueDate;
    }
    // Le livre a été ramené, fin du prêt
    public void returnBook() {
        this.isLoaned = false;
        this.dueDate = null;
    }

    public boolean isLoanedOut() {
        return isLoaned;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Implémentation des méthodes héritées de IBook via BookDecorator
    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public void setTitle(String title) {
        book.setTitle(title);
    }

    @Override
    public double getPrice() {
        return book.getPrice();
    }

    @Override
    public void setPrice(double price) {
        book.setPrice(price);
    }

    @Override
    public String preview() {
        return book.preview();
    }

    @Override
    public String toString() {
        if (isLoanedOut()) {
            return book.getTitle() + " has been loaned out. Due date: " + dueDate;
        } else {
            return book.getTitle() + " is available for a loan.";
        }
    }
}