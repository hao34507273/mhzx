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
/*     */ public final class ChineseValentineCage extends XBean implements xbean.ChineseValentineCage
/*     */ {
/*     */   private int highlightindex;
/*     */   private int pressindex;
/*     */   private long presstime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.highlightindex = 0;
/*  23 */     this.pressindex = 0;
/*  24 */     this.presstime = 0L;
/*     */   }
/*     */   
/*     */   ChineseValentineCage(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ChineseValentineCage()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChineseValentineCage(ChineseValentineCage _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChineseValentineCage(xbean.ChineseValentineCage _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof ChineseValentineCage)) { assign((ChineseValentineCage)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChineseValentineCage _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.highlightindex = _o_.highlightindex;
/*  55 */     this.pressindex = _o_.pressindex;
/*  56 */     this.presstime = _o_.presstime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.highlightindex = _o_.highlightindex;
/*  62 */     this.pressindex = _o_.pressindex;
/*  63 */     this.presstime = _o_.presstime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.highlightindex);
/*  71 */     _os_.marshal(this.pressindex);
/*  72 */     _os_.marshal(this.presstime);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.highlightindex = _os_.unmarshal_int();
/*  81 */     this.pressindex = _os_.unmarshal_int();
/*  82 */     this.presstime = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.highlightindex);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.pressindex);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.presstime);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.highlightindex);
/* 104 */       _output_.writeInt32(2, this.pressindex);
/* 105 */       _output_.writeInt64(3, this.presstime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.highlightindex = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.pressindex = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.presstime = _input_.readInt64();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChineseValentineCage copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new ChineseValentineCage(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChineseValentineCage toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChineseValentineCage toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new ChineseValentineCage(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChineseValentineCage toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChineseValentineCage toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHighlightindex()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.highlightindex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPressindex()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.pressindex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPresstime()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.presstime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHighlightindex(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "highlightindex")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, ChineseValentineCage.this.highlightindex)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             ChineseValentineCage.this.highlightindex = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.highlightindex = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPressindex(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "pressindex")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogInt(this, ChineseValentineCage.this.pressindex)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             ChineseValentineCage.this.pressindex = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.pressindex = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPresstime(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "presstime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, ChineseValentineCage.this.presstime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             ChineseValentineCage.this.presstime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.presstime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     ChineseValentineCage _o_ = null;
/* 300 */     if ((_o1_ instanceof ChineseValentineCage)) { _o_ = (ChineseValentineCage)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.highlightindex != _o_.highlightindex) return false;
/* 304 */     if (this.pressindex != _o_.pressindex) return false;
/* 305 */     if (this.presstime != _o_.presstime) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.highlightindex;
/* 315 */     _h_ += this.pressindex;
/* 316 */     _h_ = (int)(_h_ + this.presstime);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.highlightindex);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.pressindex);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.presstime);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("highlightindex"));
/* 340 */     lb.add(new ListenableChanged().setVarName("pressindex"));
/* 341 */     lb.add(new ListenableChanged().setVarName("presstime"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChineseValentineCage {
/*     */     private Const() {}
/*     */     
/*     */     ChineseValentineCage nThis() {
/* 349 */       return ChineseValentineCage.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineCage copy()
/*     */     {
/* 361 */       return ChineseValentineCage.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineCage toData()
/*     */     {
/* 367 */       return ChineseValentineCage.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineCage toBean()
/*     */     {
/* 372 */       return ChineseValentineCage.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineCage toDataIf()
/*     */     {
/* 378 */       return ChineseValentineCage.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineCage toBeanIf()
/*     */     {
/* 383 */       return ChineseValentineCage.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHighlightindex()
/*     */     {
/* 390 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 391 */       return ChineseValentineCage.this.highlightindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPressindex()
/*     */     {
/* 398 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 399 */       return ChineseValentineCage.this.pressindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPresstime()
/*     */     {
/* 406 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 407 */       return ChineseValentineCage.this.presstime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHighlightindex(int _v_)
/*     */     {
/* 414 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPressindex(int _v_)
/*     */     {
/* 422 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPresstime(long _v_)
/*     */     {
/* 430 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return ChineseValentineCage.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return ChineseValentineCage.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return ChineseValentineCage.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return ChineseValentineCage.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       ChineseValentineCage.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return ChineseValentineCage.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return ChineseValentineCage.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return ChineseValentineCage.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return ChineseValentineCage.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return ChineseValentineCage.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return ChineseValentineCage.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return ChineseValentineCage.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChineseValentineCage
/*     */   {
/*     */     private int highlightindex;
/*     */     
/*     */     private int pressindex;
/*     */     
/*     */     private long presstime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.ChineseValentineCage _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof ChineseValentineCage)) { assign((ChineseValentineCage)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof ChineseValentineCage.Const)) assign(((ChineseValentineCage.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChineseValentineCage _o_) {
/* 558 */       this.highlightindex = _o_.highlightindex;
/* 559 */       this.pressindex = _o_.pressindex;
/* 560 */       this.presstime = _o_.presstime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.highlightindex = _o_.highlightindex;
/* 566 */       this.pressindex = _o_.pressindex;
/* 567 */       this.presstime = _o_.presstime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.highlightindex);
/* 574 */       _os_.marshal(this.pressindex);
/* 575 */       _os_.marshal(this.presstime);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.highlightindex = _os_.unmarshal_int();
/* 583 */       this.pressindex = _os_.unmarshal_int();
/* 584 */       this.presstime = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.highlightindex);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.pressindex);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.presstime);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.highlightindex);
/* 604 */         _output_.writeInt32(2, this.pressindex);
/* 605 */         _output_.writeInt64(3, this.presstime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.highlightindex = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.pressindex = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.presstime = _input_.readInt64();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineCage copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineCage toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineCage toBean()
/*     */     {
/* 681 */       return new ChineseValentineCage(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineCage toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineCage toBeanIf()
/*     */     {
/* 692 */       return new ChineseValentineCage(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHighlightindex()
/*     */     {
/* 729 */       return this.highlightindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPressindex()
/*     */     {
/* 736 */       return this.pressindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPresstime()
/*     */     {
/* 743 */       return this.presstime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHighlightindex(int _v_)
/*     */     {
/* 750 */       this.highlightindex = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPressindex(int _v_)
/*     */     {
/* 757 */       this.pressindex = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPresstime(long _v_)
/*     */     {
/* 764 */       this.presstime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.highlightindex != _o_.highlightindex) return false;
/* 773 */       if (this.pressindex != _o_.pressindex) return false;
/* 774 */       if (this.presstime != _o_.presstime) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.highlightindex;
/* 783 */       _h_ += this.pressindex;
/* 784 */       _h_ = (int)(_h_ + this.presstime);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.highlightindex);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.pressindex);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.presstime);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChineseValentineCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */