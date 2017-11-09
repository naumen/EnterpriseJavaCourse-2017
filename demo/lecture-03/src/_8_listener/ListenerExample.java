package _8_listener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListenerExample {

    public static class EventBroker {
        Map<String, List<EventListener>> listeners = new HashMap<>();

        public EventBroker(String... eventTypes) {
            for (String operation : eventTypes) {
                this.listeners.put(operation, new ArrayList<>());
            }
        }

        public void subscribe(String eventType, EventListener listener) {
            List<EventListener> users = listeners.get(eventType);
            users.add(listener);
        }

        public void unsubscribe(String eventType, EventListener listener) {
            List<EventListener> users = listeners.get(eventType);
            users.remove(users.indexOf(listener));
        }

        public void newEvent(String eventType, File file) {
            List<EventListener> users = listeners.get(eventType);
            for (EventListener listener : users) {
                listener.handleEvent(eventType, file);
            }
        }
    }

    public static class Editor {
        private EventBroker eventBroker;
        private File file;

        public Editor(EventBroker eventBroker) { this.eventBroker = eventBroker; }

        public void openFile(String filePath) {
            this.file = new File(filePath);
            eventBroker.newEvent("open", file);
        }

        public void saveFile() throws Exception {
            // сохранение
            eventBroker.newEvent("save", file);
        }
    }

    public interface EventListener {
        void handleEvent(String eventType, File file);
    }

    public static class CriticalFilesChangedListener implements EventListener {
        @Override
        public void handleEvent(String eventType, File file) {
            if(isCritical(file)) { alert(); }
        }

        private boolean isCritical(File file) { return true; }
        private void alert() {}
    }

    public static class LogFileOperationsListener implements EventListener {
        @Override
        public void handleEvent(String eventType, File file) {
            System.out.println("Someone has performed " + eventType + " operation with the following file: " + file.getName());
        }
    }

    public static class Demo {
        public static void main(String[] args) {
            EventBroker eventBroker = new EventBroker("open", "save");
            Editor editor = new Editor(eventBroker);
            LogFileOperationsListener operationLogingListener = new LogFileOperationsListener();

            eventBroker.subscribe("open", operationLogingListener);
            eventBroker.subscribe("save", operationLogingListener);

            eventBroker.subscribe("save", new CriticalFilesChangedListener());

            try {
                editor.openFile("test.txt");
                editor.saveFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
