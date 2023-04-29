/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class ChessPiece extends XBean implements xbean.ChessPiece
/*     */ {
/*     */   private int chess_piece_index;
/*     */   private boolean own_by_a;
/*     */   private boolean visible;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.chess_piece_index = 0;
/*  23 */     this.own_by_a = false;
/*  24 */     this.visible = false;
/*     */   }
/*     */   
/*     */   ChessPiece(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.visible = false;
/*     */   }
/*     */   
/*     */   public ChessPiece()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChessPiece(ChessPiece _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChessPiece(xbean.ChessPiece _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof ChessPiece)) { assign((ChessPiece)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChessPiece _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.chess_piece_index = _o_.chess_piece_index;
/*  56 */     this.own_by_a = _o_.own_by_a;
/*  57 */     this.visible = _o_.visible;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.chess_piece_index = _o_.chess_piece_index;
/*  63 */     this.own_by_a = _o_.own_by_a;
/*  64 */     this.visible = _o_.visible;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.chess_piece_index);
/*  72 */     _os_.marshal(this.own_by_a);
/*  73 */     _os_.marshal(this.visible);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.chess_piece_index = _os_.unmarshal_int();
/*  82 */     this.own_by_a = _os_.unmarshal_boolean();
/*  83 */     this.visible = _os_.unmarshal_boolean();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(1, this.chess_piece_index);
/*  93 */     _size_ += CodedOutputStream.computeBoolSize(2, this.own_by_a);
/*  94 */     _size_ += CodedOutputStream.computeBoolSize(3, this.visible);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt32(1, this.chess_piece_index);
/* 105 */       _output_.writeBool(2, this.own_by_a);
/* 106 */       _output_.writeBool(3, this.visible);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.chess_piece_index = _input_.readInt32();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 139 */           this.own_by_a = _input_.readBool();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.visible = _input_.readBool();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChessPiece copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new ChessPiece(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChessPiece toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChessPiece toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new ChessPiece(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChessPiece toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChessPiece toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getChess_piece_index()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.chess_piece_index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getOwn_by_a()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.own_by_a;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getVisible()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.visible;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChess_piece_index(int _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "chess_piece_index")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogInt(this, ChessPiece.this.chess_piece_index)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             ChessPiece.this.chess_piece_index = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.chess_piece_index = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOwn_by_a(boolean _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "own_by_a")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new xdb.logs.LogObject(this, Boolean.valueOf(ChessPiece.this.own_by_a))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             ChessPiece.this.own_by_a = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.own_by_a = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setVisible(boolean _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "visible")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new xdb.logs.LogObject(this, Boolean.valueOf(ChessPiece.this.visible))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             ChessPiece.this.visible = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.visible = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     ChessPiece _o_ = null;
/* 301 */     if ((_o1_ instanceof ChessPiece)) { _o_ = (ChessPiece)_o1_;
/* 302 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 303 */       return false;
/* 304 */     if (this.chess_piece_index != _o_.chess_piece_index) return false;
/* 305 */     if (this.own_by_a != _o_.own_by_a) return false;
/* 306 */     if (this.visible != _o_.visible) return false;
/* 307 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     int _h_ = 0;
/* 315 */     _h_ += this.chess_piece_index;
/* 316 */     _h_ += (this.own_by_a ? 1231 : 1237);
/* 317 */     _h_ += (this.visible ? 1231 : 1237);
/* 318 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     StringBuilder _sb_ = new StringBuilder();
/* 326 */     _sb_.append("(");
/* 327 */     _sb_.append(this.chess_piece_index);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.own_by_a);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.visible);
/* 332 */     _sb_.append(")");
/* 333 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 339 */     ListenableBean lb = new ListenableBean();
/* 340 */     lb.add(new ListenableChanged().setVarName("chess_piece_index"));
/* 341 */     lb.add(new ListenableChanged().setVarName("own_by_a"));
/* 342 */     lb.add(new ListenableChanged().setVarName("visible"));
/* 343 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChessPiece {
/*     */     private Const() {}
/*     */     
/*     */     ChessPiece nThis() {
/* 350 */       return ChessPiece.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChessPiece copy()
/*     */     {
/* 362 */       return ChessPiece.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChessPiece toData()
/*     */     {
/* 368 */       return ChessPiece.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChessPiece toBean()
/*     */     {
/* 373 */       return ChessPiece.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChessPiece toDataIf()
/*     */     {
/* 379 */       return ChessPiece.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChessPiece toBeanIf()
/*     */     {
/* 384 */       return ChessPiece.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getChess_piece_index()
/*     */     {
/* 391 */       ChessPiece.this._xdb_verify_unsafe_();
/* 392 */       return ChessPiece.this.chess_piece_index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getOwn_by_a()
/*     */     {
/* 399 */       ChessPiece.this._xdb_verify_unsafe_();
/* 400 */       return ChessPiece.this.own_by_a;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getVisible()
/*     */     {
/* 407 */       ChessPiece.this._xdb_verify_unsafe_();
/* 408 */       return ChessPiece.this.visible;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChess_piece_index(int _v_)
/*     */     {
/* 415 */       ChessPiece.this._xdb_verify_unsafe_();
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOwn_by_a(boolean _v_)
/*     */     {
/* 423 */       ChessPiece.this._xdb_verify_unsafe_();
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVisible(boolean _v_)
/*     */     {
/* 431 */       ChessPiece.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 438 */       ChessPiece.this._xdb_verify_unsafe_();
/* 439 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 445 */       ChessPiece.this._xdb_verify_unsafe_();
/* 446 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 452 */       return ChessPiece.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 458 */       return ChessPiece.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       ChessPiece.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 471 */       return ChessPiece.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 477 */       return ChessPiece.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 483 */       ChessPiece.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 490 */       return ChessPiece.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 496 */       return ChessPiece.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 502 */       return ChessPiece.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 508 */       return ChessPiece.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 514 */       return ChessPiece.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 520 */       return ChessPiece.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 526 */       return ChessPiece.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChessPiece
/*     */   {
/*     */     private int chess_piece_index;
/*     */     
/*     */     private boolean own_by_a;
/*     */     
/*     */     private boolean visible;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 547 */       this.visible = false;
/*     */     }
/*     */     
/*     */     Data(xbean.ChessPiece _o1_)
/*     */     {
/* 552 */       if ((_o1_ instanceof ChessPiece)) { assign((ChessPiece)_o1_);
/* 553 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 554 */       } else if ((_o1_ instanceof ChessPiece.Const)) assign(((ChessPiece.Const)_o1_).nThis()); else {
/* 555 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChessPiece _o_) {
/* 560 */       this.chess_piece_index = _o_.chess_piece_index;
/* 561 */       this.own_by_a = _o_.own_by_a;
/* 562 */       this.visible = _o_.visible;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 567 */       this.chess_piece_index = _o_.chess_piece_index;
/* 568 */       this.own_by_a = _o_.own_by_a;
/* 569 */       this.visible = _o_.visible;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 575 */       _os_.marshal(this.chess_piece_index);
/* 576 */       _os_.marshal(this.own_by_a);
/* 577 */       _os_.marshal(this.visible);
/* 578 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 584 */       this.chess_piece_index = _os_.unmarshal_int();
/* 585 */       this.own_by_a = _os_.unmarshal_boolean();
/* 586 */       this.visible = _os_.unmarshal_boolean();
/* 587 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 593 */       int _size_ = 0;
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(1, this.chess_piece_index);
/* 595 */       _size_ += CodedOutputStream.computeBoolSize(2, this.own_by_a);
/* 596 */       _size_ += CodedOutputStream.computeBoolSize(3, this.visible);
/* 597 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 605 */         _output_.writeInt32(1, this.chess_piece_index);
/* 606 */         _output_.writeBool(2, this.own_by_a);
/* 607 */         _output_.writeBool(3, this.visible);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 634 */             this.chess_piece_index = _input_.readInt32();
/* 635 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 639 */             this.own_by_a = _input_.readBool();
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 644 */             this.visible = _input_.readBool();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChessPiece copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChessPiece toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChessPiece toBean()
/*     */     {
/* 683 */       return new ChessPiece(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChessPiece toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChessPiece toBeanIf()
/*     */     {
/* 694 */       return new ChessPiece(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getChess_piece_index()
/*     */     {
/* 731 */       return this.chess_piece_index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getOwn_by_a()
/*     */     {
/* 738 */       return this.own_by_a;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getVisible()
/*     */     {
/* 745 */       return this.visible;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChess_piece_index(int _v_)
/*     */     {
/* 752 */       this.chess_piece_index = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOwn_by_a(boolean _v_)
/*     */     {
/* 759 */       this.own_by_a = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVisible(boolean _v_)
/*     */     {
/* 766 */       this.visible = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 772 */       if (!(_o1_ instanceof Data)) return false;
/* 773 */       Data _o_ = (Data)_o1_;
/* 774 */       if (this.chess_piece_index != _o_.chess_piece_index) return false;
/* 775 */       if (this.own_by_a != _o_.own_by_a) return false;
/* 776 */       if (this.visible != _o_.visible) return false;
/* 777 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 783 */       int _h_ = 0;
/* 784 */       _h_ += this.chess_piece_index;
/* 785 */       _h_ += (this.own_by_a ? 1231 : 1237);
/* 786 */       _h_ += (this.visible ? 1231 : 1237);
/* 787 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 793 */       StringBuilder _sb_ = new StringBuilder();
/* 794 */       _sb_.append("(");
/* 795 */       _sb_.append(this.chess_piece_index);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.own_by_a);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.visible);
/* 800 */       _sb_.append(")");
/* 801 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChessPiece.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */