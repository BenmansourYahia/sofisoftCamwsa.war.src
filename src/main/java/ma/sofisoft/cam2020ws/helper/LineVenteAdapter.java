 package ma.sofisoft.cam2020ws.helper;

import com.google.gson.TypeAdapter;
 import com.google.gson.stream.JsonReader;
 import com.google.gson.stream.JsonWriter;
 import java.io.IOException;

 public class LineVenteAdapter<T>
  extends TypeAdapter<T>
 {
   public void write(JsonWriter writer, T value) throws IOException {
    if (value == null) {
       writer.nullValue();
      return;
   }
    writer.value(value.toString());
   }

   public T read(JsonReader in) throws IOException {
    return null;
  }
 }

