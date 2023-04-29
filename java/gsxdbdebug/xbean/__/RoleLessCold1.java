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
/*     */ public final class RoleLessCold1 extends XBean implements xbean.RoleLessCold1
/*     */ {
/*     */   private int robparadecount;
/*     */   private int robprotectcount;
/*     */   private long robparadetime;
/*     */   private long robprotecttime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.robparadecount = 0;
/*  25 */     this.robprotectcount = 0;
/*  26 */     this.robparadetime = 0L;
/*  27 */     this.robprotecttime = 0L;
/*     */   }
/*     */   
/*     */   RoleLessCold1(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public RoleLessCold1()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleLessCold1(RoleLessCold1 _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleLessCold1(xbean.RoleLessCold1 _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof RoleLessCold1)) { assign((RoleLessCold1)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleLessCold1 _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.robparadecount = _o_.robparadecount;
/*  58 */     this.robprotectcount = _o_.robprotectcount;
/*  59 */     this.robparadetime = _o_.robparadetime;
/*  60 */     this.robprotecttime = _o_.robprotecttime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.robparadecount = _o_.robparadecount;
/*  66 */     this.robprotectcount = _o_.robprotectcount;
/*  67 */     this.robparadetime = _o_.robparadetime;
/*  68 */     this.robprotecttime = _o_.robprotecttime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.robparadecount);
/*  76 */     _os_.marshal(this.robprotectcount);
/*  77 */     _os_.marshal(this.robparadetime);
/*  78 */     _os_.marshal(this.robprotecttime);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.robparadecount = _os_.unmarshal_int();
/*  87 */     this.robprotectcount = _os_.unmarshal_int();
/*  88 */     this.robparadetime = _os_.unmarshal_long();
/*  89 */     this.robprotecttime = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.robparadecount);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.robprotectcount);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(3, this.robparadetime);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.robprotecttime);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.robparadecount);
/* 112 */       _output_.writeInt32(2, this.robprotectcount);
/* 113 */       _output_.writeInt64(3, this.robparadetime);
/* 114 */       _output_.writeInt64(4, this.robprotecttime);
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
/* 142 */           this.robparadecount = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.robprotectcount = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.robparadetime = _input_.readInt64();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.robprotecttime = _input_.readInt64();
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
/*     */   public xbean.RoleLessCold1 copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new RoleLessCold1(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleLessCold1 toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleLessCold1 toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new RoleLessCold1(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleLessCold1 toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleLessCold1 toBeanIf()
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
/*     */   public int getRobparadecount()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.robparadecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRobprotectcount()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.robprotectcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRobparadetime()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.robparadetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRobprotecttime()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.robprotecttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRobparadecount(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "robparadecount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, RoleLessCold1.this.robparadecount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             RoleLessCold1.this.robparadecount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.robparadecount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRobprotectcount(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "robprotectcount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 284 */         new xdb.logs.LogInt(this, RoleLessCold1.this.robprotectcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             RoleLessCold1.this.robprotectcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.robprotectcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRobparadetime(long _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "robparadetime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 305 */         new xdb.logs.LogLong(this, RoleLessCold1.this.robparadetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             RoleLessCold1.this.robparadetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.robparadetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRobprotecttime(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "robprotecttime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 326 */         new xdb.logs.LogLong(this, RoleLessCold1.this.robprotecttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             RoleLessCold1.this.robprotecttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.robprotecttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     RoleLessCold1 _o_ = null;
/* 343 */     if ((_o1_ instanceof RoleLessCold1)) { _o_ = (RoleLessCold1)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.robparadecount != _o_.robparadecount) return false;
/* 347 */     if (this.robprotectcount != _o_.robprotectcount) return false;
/* 348 */     if (this.robparadetime != _o_.robparadetime) return false;
/* 349 */     if (this.robprotecttime != _o_.robprotecttime) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.robparadecount;
/* 359 */     _h_ += this.robprotectcount;
/* 360 */     _h_ = (int)(_h_ + this.robparadetime);
/* 361 */     _h_ = (int)(_h_ + this.robprotecttime);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.robparadecount);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.robprotectcount);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.robparadetime);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.robprotecttime);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("robparadecount"));
/* 387 */     lb.add(new ListenableChanged().setVarName("robprotectcount"));
/* 388 */     lb.add(new ListenableChanged().setVarName("robparadetime"));
/* 389 */     lb.add(new ListenableChanged().setVarName("robprotecttime"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleLessCold1 {
/*     */     private Const() {}
/*     */     
/*     */     RoleLessCold1 nThis() {
/* 397 */       return RoleLessCold1.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleLessCold1 copy()
/*     */     {
/* 409 */       return RoleLessCold1.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleLessCold1 toData()
/*     */     {
/* 415 */       return RoleLessCold1.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleLessCold1 toBean()
/*     */     {
/* 420 */       return RoleLessCold1.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleLessCold1 toDataIf()
/*     */     {
/* 426 */       return RoleLessCold1.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleLessCold1 toBeanIf()
/*     */     {
/* 431 */       return RoleLessCold1.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRobparadecount()
/*     */     {
/* 438 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 439 */       return RoleLessCold1.this.robparadecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRobprotectcount()
/*     */     {
/* 446 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 447 */       return RoleLessCold1.this.robprotectcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRobparadetime()
/*     */     {
/* 454 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 455 */       return RoleLessCold1.this.robparadetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRobprotecttime()
/*     */     {
/* 462 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 463 */       return RoleLessCold1.this.robprotecttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobparadecount(int _v_)
/*     */     {
/* 470 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobprotectcount(int _v_)
/*     */     {
/* 478 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobparadetime(long _v_)
/*     */     {
/* 486 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobprotecttime(long _v_)
/*     */     {
/* 494 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return RoleLessCold1.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return RoleLessCold1.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return RoleLessCold1.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return RoleLessCold1.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       RoleLessCold1.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return RoleLessCold1.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return RoleLessCold1.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return RoleLessCold1.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return RoleLessCold1.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return RoleLessCold1.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return RoleLessCold1.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return RoleLessCold1.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleLessCold1
/*     */   {
/*     */     private int robparadecount;
/*     */     
/*     */     private int robprotectcount;
/*     */     
/*     */     private long robparadetime;
/*     */     
/*     */     private long robprotecttime;
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
/*     */     Data(xbean.RoleLessCold1 _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof RoleLessCold1)) { assign((RoleLessCold1)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof RoleLessCold1.Const)) assign(((RoleLessCold1.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleLessCold1 _o_) {
/* 624 */       this.robparadecount = _o_.robparadecount;
/* 625 */       this.robprotectcount = _o_.robprotectcount;
/* 626 */       this.robparadetime = _o_.robparadetime;
/* 627 */       this.robprotecttime = _o_.robprotecttime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.robparadecount = _o_.robparadecount;
/* 633 */       this.robprotectcount = _o_.robprotectcount;
/* 634 */       this.robparadetime = _o_.robparadetime;
/* 635 */       this.robprotecttime = _o_.robprotecttime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.robparadecount);
/* 642 */       _os_.marshal(this.robprotectcount);
/* 643 */       _os_.marshal(this.robparadetime);
/* 644 */       _os_.marshal(this.robprotecttime);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.robparadecount = _os_.unmarshal_int();
/* 652 */       this.robprotectcount = _os_.unmarshal_int();
/* 653 */       this.robparadetime = _os_.unmarshal_long();
/* 654 */       this.robprotecttime = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.robparadecount);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.robprotectcount);
/* 664 */       _size_ += CodedOutputStream.computeInt64Size(3, this.robparadetime);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.robprotecttime);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.robparadecount);
/* 675 */         _output_.writeInt32(2, this.robprotectcount);
/* 676 */         _output_.writeInt64(3, this.robparadetime);
/* 677 */         _output_.writeInt64(4, this.robprotecttime);
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
/* 704 */             this.robparadecount = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.robprotectcount = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.robparadetime = _input_.readInt64();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.robprotecttime = _input_.readInt64();
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
/*     */     public xbean.RoleLessCold1 copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleLessCold1 toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleLessCold1 toBean()
/*     */     {
/* 758 */       return new RoleLessCold1(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleLessCold1 toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleLessCold1 toBeanIf()
/*     */     {
/* 769 */       return new RoleLessCold1(this, null, null);
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
/*     */     public int getRobparadecount()
/*     */     {
/* 806 */       return this.robparadecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRobprotectcount()
/*     */     {
/* 813 */       return this.robprotectcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRobparadetime()
/*     */     {
/* 820 */       return this.robparadetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRobprotecttime()
/*     */     {
/* 827 */       return this.robprotecttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobparadecount(int _v_)
/*     */     {
/* 834 */       this.robparadecount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobprotectcount(int _v_)
/*     */     {
/* 841 */       this.robprotectcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobparadetime(long _v_)
/*     */     {
/* 848 */       this.robparadetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRobprotecttime(long _v_)
/*     */     {
/* 855 */       this.robprotecttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.robparadecount != _o_.robparadecount) return false;
/* 864 */       if (this.robprotectcount != _o_.robprotectcount) return false;
/* 865 */       if (this.robparadetime != _o_.robparadetime) return false;
/* 866 */       if (this.robprotecttime != _o_.robprotecttime) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.robparadecount;
/* 875 */       _h_ += this.robprotectcount;
/* 876 */       _h_ = (int)(_h_ + this.robparadetime);
/* 877 */       _h_ = (int)(_h_ + this.robprotecttime);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.robparadecount);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.robprotectcount);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.robparadetime);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.robprotecttime);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleLessCold1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */