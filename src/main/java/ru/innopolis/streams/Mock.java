package ru.innopolis.streams;

/**
 * Created by Igor Ryabtsev on 11.11.2016.
 */
public class Mock {

    private StreamWriter streamWriter;
    private StreamReader streamReader;

    public String calculate(Long id){
        String obj = this.streamReader.read(id);
        return calculateObj(obj);
    }

    private String calculateObj(String obj) {
        return "calculated " + obj;
    }

    public StreamWriter getStreamWriter() {
        return streamWriter;
    }

    public void setStreamWriter(StreamWriter streamWriter) {
        this.streamWriter = streamWriter;
    }

    public StreamReader getStreamReader() {
        return streamReader;
    }

    public void setStreamReader(StreamReader streamReader) {
        this.streamReader = streamReader;
    }
}
