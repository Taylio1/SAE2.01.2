import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;

public class LabyrintheView {
    private final GridPane root;
    private final int tailleCase = 50;
    private boolean sortiePlacee = false;

    public LabyrintheView(int lignes, int colonnes) {
        root = new GridPane();
        root.setAlignment(Pos.CENTER);

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                StackPane casePane = new StackPane();
                casePane.setPrefSize(tailleCase, tailleCase);
                casePane.setStyle("-fx-border-color: black; -fx-background-color: lightgray");

                String type = (i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) ? "rocher" : "vide";
                if (!type.equals("vide")) {
                    ImageView img = new ImageView(getImageParType(type));
                    img.setFitWidth(tailleCase - 5);
                    img.setFitHeight(tailleCase - 5);
                    casePane.getChildren().add(img);
                }

                final int row = i;
                final int col = j;

                casePane.setOnDragOver(event -> {
                    if (event.getGestureSource() != casePane && event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }
                    event.consume();
                });

                casePane.setOnDragDropped(event -> {
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        String typeDrop = db.getString();
                        if (typeDrop.equals("sortie")) {
                            if (!sortiePlacee) {
                                casePane.getChildren().clear();
                                ImageView img = new ImageView(getImageParType("sortie"));
                                img.setFitWidth(tailleCase - 5);
                                img.setFitHeight(tailleCase - 5);
                                casePane.getChildren().add(img);
                                sortiePlacee = true;
                                success = true;
                            }
                        } else {
                            casePane.getChildren().clear();
                            ImageView img = new ImageView(getImageParType(typeDrop));
                            img.setFitWidth(tailleCase - 5);
                            img.setFitHeight(tailleCase - 5);
                            casePane.getChildren().add(img);
                            success = true;
                        }
                    }
                    event.setDropCompleted(success);
                    event.consume();
                });

                root.add(casePane, j, i);
            }
        }
    }

    public GridPane getRoot() {
        return root;
    }

    private Image getImageParType(String type) {
        return switch (type) {
            case "herbe" -> new Image("images/herbe.png");
            case "cactus" -> new Image("images/cactus.png");
            case "marguerite" -> new Image("images/marguerite.png");
            case "rocher" -> new Image("images/rocher.png");
            case "mouton" -> new Image("images/mouton.png");
            case "loup" -> new Image("images/loup.png");
            case "sortie" -> new Image("images/sortie.png");
            default -> null;
        };
    }
}