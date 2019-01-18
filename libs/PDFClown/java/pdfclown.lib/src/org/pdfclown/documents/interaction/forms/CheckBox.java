/*
  Copyright 2008-2012 Stefano Chizzolini. http://www.pdfclown.org

  Contributors:
    * Stefano Chizzolini (original code developer, http://www.stefanochizzolini.it)

  This file should be part of the source code distribution of "PDF Clown library"
  (the Program): see the accompanying README files for more info.

  This Program is free software; you can redistribute it and/or modify it under the terms
  of the GNU Lesser General Public License as published by the Free Software Foundation;
  either version 3 of the License, or (at your option) any later version.

  This Program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY,
  either expressed or implied; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the License for more details.

  You should have received a copy of the GNU Lesser General Public License along with this
  Program (see README files); if not, go to the GNU website (http://www.gnu.org/licenses/).

  Redistribution and use, with or without modification, are permitted provided that such
  redistributions retain the above copyright notice, license and disclaimer, along with
  this list of conditions.
*/

package org.pdfclown.documents.interaction.forms;

import org.pdfclown.PDF;
import org.pdfclown.VersionEnum;
import org.pdfclown.documents.Document;
import org.pdfclown.documents.interaction.annotations.Widget;
import org.pdfclown.objects.PdfDictionary;
import org.pdfclown.objects.PdfDirectObject;
import org.pdfclown.objects.PdfName;

/**
  Check box field [PDF:1.6:8.6.3].

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @since 0.0.7
  @version 0.1.2, 12/21/12
*/
@PDF(VersionEnum.PDF12)
public final class CheckBox
  extends ButtonField
{
  // <class>
  // <dynamic>
  // <constructors>
  /**
    Creates a new checkbox within the given document context.
  */
  public CheckBox(
    String name,
    Widget widget,
    boolean checked
    )
  {
    super(name, widget);
    setChecked(checked);
  }

  CheckBox(
    PdfDirectObject baseObject
    )
  {super(baseObject);}
  // </constructors>

  // <interface>
  // <public>
  @Override
  public CheckBox clone(
    Document context
    )
  {return (CheckBox)super.clone(context);}

  public boolean isChecked(
    )
  {
    PdfName value = (PdfName)getBaseDataObject().get(PdfName.V);
    return !(value == null || value.equals(PdfName.Off));
  }

  public void setChecked(
    boolean value
    )
  {
    PdfDictionary widgetDictionary = getWidgets().get(0).getBaseDataObject();
    /*
      NOTE: The appearance for the off state is optional but, if present, MUST be stored in the
      appearance dictionary under the name Off. The recommended (but NOT required) name for the on
      state is Yes.
    */
    PdfName baseValue = null;
    if(value)
    {
      PdfDictionary appearanceDictionary = (PdfDictionary)widgetDictionary.resolve(PdfName.AP);
      if(appearanceDictionary != null)
      {
        for(PdfName appearanceKey : ((PdfDictionary)appearanceDictionary.resolve(PdfName.N)).keySet())
        {
          if(!appearanceKey.equals(PdfName.Off))
          {
            baseValue = appearanceKey;
            break;
          }
        }
      }
      else
      {baseValue = PdfName.Yes;}
    }
    else
    {baseValue = PdfName.Off;}
    getBaseDataObject().put(PdfName.V,baseValue);
    widgetDictionary.put(PdfName.AS,baseValue);
  }

  @Override
  public void setValue(
    Object value
    )
  {setChecked(!(value == null || value.equals("") || value.equals(PdfName.Off.getValue())));}
  // </public>
  // </interface>
  // </dynamic>
  // </class>
}