package com.ftn.sbnz.model.user;

import com.ftn.sbnz.model.enums.Sunlight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvironmentPreferences {
    private ArrayList<Sunlight> sunlight = new ArrayList<>();
    private Position position;
    private Room room;

    public enum Room {
        LivingRoom("Living room"),
        Bedroom("Bedroom"),
        Office("Office"),
        Kitchen("Kitchen"),
        Bathroom("Bathroom"),
        Other("Other");

        private final String value;

        Room(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Position {
        Window("Window"),
        ByDoor("Nex to door"),
        Corner("In corner"),
        Other("Other/ not important/ don't know");

        private final String value;

        Position(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
