// Generated by view binder compiler. Do not edit!
package org.wit.assignment2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.wit.assignment2.R;

public final class CardExerciseBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView description;

  @NonNull
  public final TextView exerciseTitle;

  @NonNull
  public final ImageView imageIcon;

  @NonNull
  public final ConstraintLayout relativeLayout;

  private CardExerciseBinding(@NonNull CardView rootView, @NonNull TextView description,
      @NonNull TextView exerciseTitle, @NonNull ImageView imageIcon,
      @NonNull ConstraintLayout relativeLayout) {
    this.rootView = rootView;
    this.description = description;
    this.exerciseTitle = exerciseTitle;
    this.imageIcon = imageIcon;
    this.relativeLayout = relativeLayout;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardExerciseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardExerciseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_exercise, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardExerciseBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.description;
      TextView description = ViewBindings.findChildViewById(rootView, id);
      if (description == null) {
        break missingId;
      }

      id = R.id.exerciseTitle;
      TextView exerciseTitle = ViewBindings.findChildViewById(rootView, id);
      if (exerciseTitle == null) {
        break missingId;
      }

      id = R.id.imageIcon;
      ImageView imageIcon = ViewBindings.findChildViewById(rootView, id);
      if (imageIcon == null) {
        break missingId;
      }

      id = R.id.relativeLayout;
      ConstraintLayout relativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayout == null) {
        break missingId;
      }

      return new CardExerciseBinding((CardView) rootView, description, exerciseTitle, imageIcon,
          relativeLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
