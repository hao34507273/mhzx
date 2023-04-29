/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class Ceremony extends XBean implements xbean.Ceremony
/*     */ {
/*     */   private long roleid1;
/*     */   private long roleid2;
/*     */   private int stage;
/*     */   private int level;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.roleid1 = 0L;
/*  25 */     this.roleid2 = 0L;
/*  26 */     this.stage = 0;
/*  27 */     this.level = 0;
/*     */   }
/*     */   
/*     */   Ceremony(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public Ceremony()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Ceremony(Ceremony _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Ceremony(xbean.Ceremony _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof Ceremony)) { assign((Ceremony)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Ceremony _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.roleid1 = _o_.roleid1;
/*  58 */     this.roleid2 = _o_.roleid2;
/*  59 */     this.stage = _o_.stage;
/*  60 */     this.level = _o_.level;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.roleid1 = _o_.roleid1;
/*  66 */     this.roleid2 = _o_.roleid2;
/*  67 */     this.stage = _o_.stage;
/*  68 */     this.level = _o_.level;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.roleid1);
/*  76 */     _os_.marshal(this.roleid2);
/*  77 */     _os_.marshal(this.stage);
/*  78 */     _os_.marshal(this.level);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.roleid1 = _os_.unmarshal_long();
/*  87 */     this.roleid2 = _os_.unmarshal_long();
/*  88 */     this.stage = _os_.unmarshal_int();
/*  89 */     this.level = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid1);
/*  99 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleid2);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.stage);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.level);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.roleid1);
/* 112 */       _output_.writeInt64(2, this.roleid2);
/* 113 */       _output_.writeInt32(3, this.stage);
/* 114 */       _output_.writeInt32(4, this.level);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.roleid1 = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.roleid2 = _input_.readInt64();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.stage = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.level = _input_.readInt32();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 162 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 164 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 173 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Ceremony copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Ceremony(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Ceremony toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Ceremony toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Ceremony(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Ceremony toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Ceremony toBeanIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid1()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.roleid1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid2()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.roleid2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getStage()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.stage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid1(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "roleid1")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 263 */         new xdb.logs.LogLong(this, Ceremony.this.roleid1)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             Ceremony.this.roleid1 = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.roleid1 = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid2(long _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "roleid2")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 284 */         new xdb.logs.LogLong(this, Ceremony.this.roleid2)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             Ceremony.this.roleid2 = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.roleid2 = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStage(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "stage")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 305 */         new xdb.logs.LogInt(this, Ceremony.this.stage)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             Ceremony.this.stage = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.stage = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, Ceremony.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             Ceremony.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     Ceremony _o_ = null;
/* 343 */     if ((_o1_ instanceof Ceremony)) { _o_ = (Ceremony)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.roleid1 != _o_.roleid1) return false;
/* 347 */     if (this.roleid2 != _o_.roleid2) return false;
/* 348 */     if (this.stage != _o_.stage) return false;
/* 349 */     if (this.level != _o_.level) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.roleid1);
/* 359 */     _h_ = (int)(_h_ + this.roleid2);
/* 360 */     _h_ += this.stage;
/* 361 */     _h_ += this.level;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.roleid1);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.roleid2);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.stage);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.level);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("roleid1"));
/* 387 */     lb.add(new ListenableChanged().setVarName("roleid2"));
/* 388 */     lb.add(new ListenableChanged().setVarName("stage"));
/* 389 */     lb.add(new ListenableChanged().setVarName("level"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Ceremony {
/*     */     private Const() {}
/*     */     
/*     */     Ceremony nThis() {
/* 397 */       return Ceremony.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremony copy()
/*     */     {
/* 409 */       return Ceremony.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremony toData()
/*     */     {
/* 415 */       return Ceremony.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Ceremony toBean()
/*     */     {
/* 420 */       return Ceremony.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremony toDataIf()
/*     */     {
/* 426 */       return Ceremony.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Ceremony toBeanIf()
/*     */     {
/* 431 */       return Ceremony.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid1()
/*     */     {
/* 438 */       Ceremony.this._xdb_verify_unsafe_();
/* 439 */       return Ceremony.this.roleid1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid2()
/*     */     {
/* 446 */       Ceremony.this._xdb_verify_unsafe_();
/* 447 */       return Ceremony.this.roleid2;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 454 */       Ceremony.this._xdb_verify_unsafe_();
/* 455 */       return Ceremony.this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 462 */       Ceremony.this._xdb_verify_unsafe_();
/* 463 */       return Ceremony.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid1(long _v_)
/*     */     {
/* 470 */       Ceremony.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid2(long _v_)
/*     */     {
/* 478 */       Ceremony.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 486 */       Ceremony.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 494 */       Ceremony.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       Ceremony.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       Ceremony.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return Ceremony.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return Ceremony.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       Ceremony.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return Ceremony.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return Ceremony.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       Ceremony.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return Ceremony.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return Ceremony.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return Ceremony.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return Ceremony.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return Ceremony.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return Ceremony.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return Ceremony.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Ceremony
/*     */   {
/*     */     private long roleid1;
/*     */     
/*     */     private long roleid2;
/*     */     
/*     */     private int stage;
/*     */     
/*     */     private int level;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.Ceremony _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof Ceremony)) { assign((Ceremony)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof Ceremony.Const)) assign(((Ceremony.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Ceremony _o_) {
/* 624 */       this.roleid1 = _o_.roleid1;
/* 625 */       this.roleid2 = _o_.roleid2;
/* 626 */       this.stage = _o_.stage;
/* 627 */       this.level = _o_.level;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.roleid1 = _o_.roleid1;
/* 633 */       this.roleid2 = _o_.roleid2;
/* 634 */       this.stage = _o_.stage;
/* 635 */       this.level = _o_.level;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.roleid1);
/* 642 */       _os_.marshal(this.roleid2);
/* 643 */       _os_.marshal(this.stage);
/* 644 */       _os_.marshal(this.level);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.roleid1 = _os_.unmarshal_long();
/* 652 */       this.roleid2 = _os_.unmarshal_long();
/* 653 */       this.stage = _os_.unmarshal_int();
/* 654 */       this.level = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid1);
/* 663 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleid2);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.stage);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.level);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.roleid1);
/* 675 */         _output_.writeInt64(2, this.roleid2);
/* 676 */         _output_.writeInt32(3, this.stage);
/* 677 */         _output_.writeInt32(4, this.level);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.roleid1 = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.roleid2 = _input_.readInt64();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.stage = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.level = _input_.readInt32();
/* 720 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 724 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 726 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 735 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 739 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 741 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremony copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremony toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Ceremony toBean()
/*     */     {
/* 758 */       return new Ceremony(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremony toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Ceremony toBeanIf()
/*     */     {
/* 769 */       return new Ceremony(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 775 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 795 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid1()
/*     */     {
/* 806 */       return this.roleid1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid2()
/*     */     {
/* 813 */       return this.roleid2;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 820 */       return this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 827 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid1(long _v_)
/*     */     {
/* 834 */       this.roleid1 = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid2(long _v_)
/*     */     {
/* 841 */       this.roleid2 = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 848 */       this.stage = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 855 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.roleid1 != _o_.roleid1) return false;
/* 864 */       if (this.roleid2 != _o_.roleid2) return false;
/* 865 */       if (this.stage != _o_.stage) return false;
/* 866 */       if (this.level != _o_.level) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.roleid1);
/* 875 */       _h_ = (int)(_h_ + this.roleid2);
/* 876 */       _h_ += this.stage;
/* 877 */       _h_ += this.level;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.roleid1);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.roleid2);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.stage);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.level);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Ceremony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */