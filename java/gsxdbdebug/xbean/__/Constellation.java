/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class Constellation extends XBean implements xbean.Constellation
/*     */ {
/*     */   private ArrayList<xbean.ConstellationCards> cards;
/*     */   private int index;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.cards.clear();
/*  21 */     this.index = 0;
/*     */   }
/*     */   
/*     */   Constellation(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.cards = new ArrayList();
/*  28 */     this.index = 0;
/*     */   }
/*     */   
/*     */   public Constellation()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Constellation(Constellation _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Constellation(xbean.Constellation _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof Constellation)) { assign((Constellation)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Constellation _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.cards = new ArrayList();
/*  54 */     for (xbean.ConstellationCards _v_ : _o_.cards)
/*  55 */       this.cards.add(new ConstellationCards(_v_, this, "cards"));
/*  56 */     this.index = _o_.index;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.cards = new ArrayList();
/*  62 */     for (xbean.ConstellationCards _v_ : _o_.cards)
/*  63 */       this.cards.add(new ConstellationCards(_v_, this, "cards"));
/*  64 */     this.index = _o_.index;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.cards.size());
/*  72 */     for (xbean.ConstellationCards _v_ : this.cards)
/*     */     {
/*  74 */       _v_.marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.index);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  86 */       xbean.ConstellationCards _v_ = new ConstellationCards(0, this, "cards");
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.cards.add(_v_);
/*     */     }
/*  90 */     this.index = _os_.unmarshal_int();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     for (xbean.ConstellationCards _v_ : this.cards)
/*     */     {
/* 101 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(2, this.index);
/* 104 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       for (xbean.ConstellationCards _v_ : this.cards)
/*     */       {
/* 115 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 117 */       _output_.writeInt32(2, this.index);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 121 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 123 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 132 */       boolean done = false;
/* 133 */       while (!done)
/*     */       {
/* 135 */         int tag = _input_.readTag();
/* 136 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 140 */           done = true;
/* 141 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 145 */           xbean.ConstellationCards _v_ = new ConstellationCards(0, this, "cards");
/* 146 */           _input_.readMessage(_v_);
/* 147 */           this.cards.add(_v_);
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 152 */           this.index = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 157 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 159 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 168 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 172 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 174 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Constellation copy()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     return new Constellation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Constellation toData()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Constellation toBean()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Constellation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Constellation toDataIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Constellation toBeanIf()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.ConstellationCards> getCards()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return xdb.Logs.logList(new LogKey(this, "cards"), this.cards);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.ConstellationCards> getCardsAsData()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/*     */     
/* 230 */     Constellation _o_ = this;
/* 231 */     List<xbean.ConstellationCards> cards = new ArrayList();
/* 232 */     for (xbean.ConstellationCards _v_ : _o_.cards)
/* 233 */       cards.add(new ConstellationCards.Data(_v_));
/* 234 */     return cards;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIndex()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return this.index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIndex(int _v_)
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/* 250 */     xdb.Logs.logIf(new LogKey(this, "index")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 254 */         new xdb.logs.LogInt(this, Constellation.this.index)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 258 */             Constellation.this.index = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 262 */     });
/* 263 */     this.index = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     Constellation _o_ = null;
/* 271 */     if ((_o1_ instanceof Constellation)) { _o_ = (Constellation)_o1_;
/* 272 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 273 */       return false;
/* 274 */     if (!this.cards.equals(_o_.cards)) return false;
/* 275 */     if (this.index != _o_.index) return false;
/* 276 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     int _h_ = 0;
/* 284 */     _h_ += this.cards.hashCode();
/* 285 */     _h_ += this.index;
/* 286 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     StringBuilder _sb_ = new StringBuilder();
/* 294 */     _sb_.append("(");
/* 295 */     _sb_.append(this.cards);
/* 296 */     _sb_.append(",");
/* 297 */     _sb_.append(this.index);
/* 298 */     _sb_.append(")");
/* 299 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 305 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 306 */     lb.add(new xdb.logs.ListenableChanged().setVarName("cards"));
/* 307 */     lb.add(new xdb.logs.ListenableChanged().setVarName("index"));
/* 308 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Constellation {
/*     */     private Const() {}
/*     */     
/*     */     Constellation nThis() {
/* 315 */       return Constellation.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 321 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Constellation copy()
/*     */     {
/* 327 */       return Constellation.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Constellation toData()
/*     */     {
/* 333 */       return Constellation.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Constellation toBean()
/*     */     {
/* 338 */       return Constellation.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Constellation toDataIf()
/*     */     {
/* 344 */       return Constellation.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Constellation toBeanIf()
/*     */     {
/* 349 */       return Constellation.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.ConstellationCards> getCards()
/*     */     {
/* 356 */       Constellation.this._xdb_verify_unsafe_();
/* 357 */       return xdb.Consts.constList(Constellation.this.cards);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.ConstellationCards> getCardsAsData()
/*     */     {
/* 363 */       Constellation.this._xdb_verify_unsafe_();
/*     */       
/* 365 */       Constellation _o_ = Constellation.this;
/* 366 */       List<xbean.ConstellationCards> cards = new ArrayList();
/* 367 */       for (xbean.ConstellationCards _v_ : _o_.cards)
/* 368 */         cards.add(new ConstellationCards.Data(_v_));
/* 369 */       return cards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIndex()
/*     */     {
/* 376 */       Constellation.this._xdb_verify_unsafe_();
/* 377 */       return Constellation.this.index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIndex(int _v_)
/*     */     {
/* 384 */       Constellation.this._xdb_verify_unsafe_();
/* 385 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 391 */       Constellation.this._xdb_verify_unsafe_();
/* 392 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 398 */       Constellation.this._xdb_verify_unsafe_();
/* 399 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 405 */       return Constellation.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 411 */       return Constellation.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 417 */       Constellation.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 424 */       return Constellation.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 430 */       return Constellation.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 436 */       Constellation.this._xdb_verify_unsafe_();
/* 437 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 443 */       return Constellation.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 449 */       return Constellation.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 455 */       return Constellation.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 461 */       return Constellation.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 467 */       return Constellation.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 473 */       return Constellation.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 479 */       return Constellation.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Constellation
/*     */   {
/*     */     private ArrayList<xbean.ConstellationCards> cards;
/*     */     
/*     */     private int index;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 493 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 498 */       this.cards = new ArrayList();
/* 499 */       this.index = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.Constellation _o1_)
/*     */     {
/* 504 */       if ((_o1_ instanceof Constellation)) { assign((Constellation)_o1_);
/* 505 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 506 */       } else if ((_o1_ instanceof Constellation.Const)) assign(((Constellation.Const)_o1_).nThis()); else {
/* 507 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Constellation _o_) {
/* 512 */       this.cards = new ArrayList();
/* 513 */       for (xbean.ConstellationCards _v_ : _o_.cards)
/* 514 */         this.cards.add(new ConstellationCards.Data(_v_));
/* 515 */       this.index = _o_.index;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 520 */       this.cards = new ArrayList();
/* 521 */       for (xbean.ConstellationCards _v_ : _o_.cards)
/* 522 */         this.cards.add(new ConstellationCards.Data(_v_));
/* 523 */       this.index = _o_.index;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 529 */       _os_.compact_uint32(this.cards.size());
/* 530 */       for (xbean.ConstellationCards _v_ : this.cards)
/*     */       {
/* 532 */         _v_.marshal(_os_);
/*     */       }
/* 534 */       _os_.marshal(this.index);
/* 535 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 541 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 543 */         xbean.ConstellationCards _v_ = xbean.Pod.newConstellationCardsData();
/* 544 */         _v_.unmarshal(_os_);
/* 545 */         this.cards.add(_v_);
/*     */       }
/* 547 */       this.index = _os_.unmarshal_int();
/* 548 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 554 */       int _size_ = 0;
/* 555 */       for (xbean.ConstellationCards _v_ : this.cards)
/*     */       {
/* 557 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 559 */       _size_ += CodedOutputStream.computeInt32Size(2, this.index);
/* 560 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 568 */         for (xbean.ConstellationCards _v_ : this.cards)
/*     */         {
/* 570 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 572 */         _output_.writeInt32(2, this.index);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 576 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 578 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 586 */         boolean done = false;
/* 587 */         while (!done)
/*     */         {
/* 589 */           int tag = _input_.readTag();
/* 590 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 594 */             done = true;
/* 595 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 599 */             xbean.ConstellationCards _v_ = xbean.Pod.newConstellationCardsData();
/* 600 */             _input_.readMessage(_v_);
/* 601 */             this.cards.add(_v_);
/* 602 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 606 */             this.index = _input_.readInt32();
/* 607 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 611 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 613 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 622 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 626 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 628 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Constellation copy()
/*     */     {
/* 634 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Constellation toData()
/*     */     {
/* 640 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Constellation toBean()
/*     */     {
/* 645 */       return new Constellation(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Constellation toDataIf()
/*     */     {
/* 651 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Constellation toBeanIf()
/*     */     {
/* 656 */       return new Constellation(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 666 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 674 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 678 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 682 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 686 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.ConstellationCards> getCards()
/*     */     {
/* 693 */       return this.cards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.ConstellationCards> getCardsAsData()
/*     */     {
/* 700 */       return this.cards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIndex()
/*     */     {
/* 707 */       return this.index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIndex(int _v_)
/*     */     {
/* 714 */       this.index = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 720 */       if (!(_o1_ instanceof Data)) return false;
/* 721 */       Data _o_ = (Data)_o1_;
/* 722 */       if (!this.cards.equals(_o_.cards)) return false;
/* 723 */       if (this.index != _o_.index) return false;
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 730 */       int _h_ = 0;
/* 731 */       _h_ += this.cards.hashCode();
/* 732 */       _h_ += this.index;
/* 733 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 739 */       StringBuilder _sb_ = new StringBuilder();
/* 740 */       _sb_.append("(");
/* 741 */       _sb_.append(this.cards);
/* 742 */       _sb_.append(",");
/* 743 */       _sb_.append(this.index);
/* 744 */       _sb_.append(")");
/* 745 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Constellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */