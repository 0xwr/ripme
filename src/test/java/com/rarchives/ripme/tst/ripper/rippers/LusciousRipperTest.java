package com.rarchives.ripme.tst.ripper.rippers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.rarchives.ripme.ripper.rippers.LusciousRipper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LusciousRipperTest extends RippersTest {
    @Test
    @Disabled("test or ripper broken")
    public void testPahealRipper() throws IOException, URISyntaxException {
        // a photo set
        LusciousRipper ripper = new LusciousRipper(
                new URI("https://luscious.net/albums/h-na-alice-wa-suki-desu-ka-do-you-like-alice-when_321609/").toURL());
        testRipper(ripper);
    }

    @Test
    public void testGetGID() throws IOException, URISyntaxException {
        URL url = new URI("https://luscious.net/albums/h-na-alice-wa-suki-desu-ka-do-you-like-alice-when_321609/").toURL();
        LusciousRipper ripper = new LusciousRipper(url);
        Assertions.assertEquals("h-na-alice-wa-suki-desu-ka-do-you-like-alice-when_321609", ripper.getGID(url));
    }
    
    @Test
    @Disabled("test or ripper broken")
    public void testGetNextPage() throws IOException, URISyntaxException {
        URL multiPageAlbumUrl = new URI("https://luscious.net/albums/women-of-color_58/").toURL();
        LusciousRipper multiPageRipper = new LusciousRipper(multiPageAlbumUrl);
        assert (multiPageRipper.getNextPage(multiPageRipper.getFirstPage()) != null);

        URL singlePageAlbumUrl = new URI("https://members.luscious.net/albums/bakaneko-navidarks_332097/").toURL();
        LusciousRipper singlePageRipper = new LusciousRipper(singlePageAlbumUrl);
        try {
            singlePageRipper.getNextPage(singlePageRipper.getFirstPage());
        } catch (IOException e) {
            Assertions.assertEquals("No next page found.", e.getMessage());
        }
    }
}