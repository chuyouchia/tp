package seedu.flashnotes.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.flashnotes.commons.exceptions.DataConversionException;
import seedu.flashnotes.model.FlashNotes;
import seedu.flashnotes.model.ReadOnlyFlashNotes;
import seedu.flashnotes.model.deck.UniqueDeckList;

/**
 * Represents a storage for {@link FlashNotes}.
 */
public interface FlashNotesStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getFlashNotesFilePath();

    /**
     * Returns FlashNotes data as a {@link ReadOnlyFlashNotes}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyFlashNotes> readFlashNotes() throws DataConversionException, IOException;

    /**
     * @see #getFlashNotesFilePath()
     */
    Optional<ReadOnlyFlashNotes> readFlashNotes(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyFlashNotes} to the storage.
     * @param flashNotes cannot be null.
     * @param deckList unqiue decklist
     * @throws IOException if there was any problem writing to the file.
     */
    void saveFlashNotes(ReadOnlyFlashNotes flashNotes, UniqueDeckList deckList) throws IOException;

    /**
     * @see #saveFlashNotes(ReadOnlyFlashNotes, UniqueDeckList)
     */
    void saveFlashNotes(ReadOnlyFlashNotes flashNotes, Path filePath, UniqueDeckList deckList) throws IOException;

}
