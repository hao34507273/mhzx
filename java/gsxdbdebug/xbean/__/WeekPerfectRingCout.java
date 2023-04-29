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
/*     */ 
/*     */ public final class WeekPerfectRingCout extends XBean implements xbean.WeekPerfectRingCout
/*     */ {
/*     */   private int weekperfectringcount;
/*     */   private long cleantime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.weekperfectringcount = 0;
/*  21 */     this.cleantime = 0L;
/*     */   }
/*     */   
/*     */   WeekPerfectRingCout(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.weekperfectringcount = 0;
/*     */   }
/*     */   
/*     */   public WeekPerfectRingCout()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public WeekPerfectRingCout(WeekPerfectRingCout _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   WeekPerfectRingCout(xbean.WeekPerfectRingCout _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof WeekPerfectRingCout)) { assign((WeekPerfectRingCout)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(WeekPerfectRingCout _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.weekperfectringcount = _o_.weekperfectringcount;
/*  53 */     this.cleantime = _o_.cleantime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.weekperfectringcount = _o_.weekperfectringcount;
/*  59 */     this.cleantime = _o_.cleantime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.weekperfectringcount);
/*  67 */     _os_.marshal(this.cleantime);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.weekperfectringcount = _os_.unmarshal_int();
/*  76 */     this.cleantime = _os_.unmarshal_long();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(1, this.weekperfectringcount);
/*  86 */     _size_ += CodedOutputStream.computeInt64Size(2, this.cleantime);
/*  87 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  96 */       _output_.writeInt32(1, this.weekperfectringcount);
/*  97 */       _output_.writeInt64(2, this.cleantime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 101 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 103 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       boolean done = false;
/* 113 */       while (!done)
/*     */       {
/* 115 */         int tag = _input_.readTag();
/* 116 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 120 */           done = true;
/* 121 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 125 */           this.weekperfectringcount = _input_.readInt32();
/* 126 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 130 */           this.cleantime = _input_.readInt64();
/* 131 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 135 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 137 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 146 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WeekPerfectRingCout copy()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return new WeekPerfectRingCout(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WeekPerfectRingCout toData()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WeekPerfectRingCout toBean()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new WeekPerfectRingCout(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WeekPerfectRingCout toDataIf()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WeekPerfectRingCout toBeanIf()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getWeekperfectringcount()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this.weekperfectringcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCleantime()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return this.cleantime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWeekperfectringcount(int _v_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     xdb.Logs.logIf(new LogKey(this, "weekperfectringcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 220 */         new xdb.logs.LogInt(this, WeekPerfectRingCout.this.weekperfectringcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 224 */             WeekPerfectRingCout.this.weekperfectringcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 228 */     });
/* 229 */     this.weekperfectringcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCleantime(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "cleantime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogLong(this, WeekPerfectRingCout.this.cleantime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             WeekPerfectRingCout.this.cleantime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.cleantime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     WeekPerfectRingCout _o_ = null;
/* 258 */     if ((_o1_ instanceof WeekPerfectRingCout)) { _o_ = (WeekPerfectRingCout)_o1_;
/* 259 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 260 */       return false;
/* 261 */     if (this.weekperfectringcount != _o_.weekperfectringcount) return false;
/* 262 */     if (this.cleantime != _o_.cleantime) return false;
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     int _h_ = 0;
/* 271 */     _h_ += this.weekperfectringcount;
/* 272 */     _h_ = (int)(_h_ + this.cleantime);
/* 273 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     StringBuilder _sb_ = new StringBuilder();
/* 281 */     _sb_.append("(");
/* 282 */     _sb_.append(this.weekperfectringcount);
/* 283 */     _sb_.append(",");
/* 284 */     _sb_.append(this.cleantime);
/* 285 */     _sb_.append(")");
/* 286 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 292 */     ListenableBean lb = new ListenableBean();
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("weekperfectringcount"));
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("cleantime"));
/* 295 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.WeekPerfectRingCout {
/*     */     private Const() {}
/*     */     
/*     */     WeekPerfectRingCout nThis() {
/* 302 */       return WeekPerfectRingCout.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WeekPerfectRingCout copy()
/*     */     {
/* 314 */       return WeekPerfectRingCout.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WeekPerfectRingCout toData()
/*     */     {
/* 320 */       return WeekPerfectRingCout.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.WeekPerfectRingCout toBean()
/*     */     {
/* 325 */       return WeekPerfectRingCout.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WeekPerfectRingCout toDataIf()
/*     */     {
/* 331 */       return WeekPerfectRingCout.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.WeekPerfectRingCout toBeanIf()
/*     */     {
/* 336 */       return WeekPerfectRingCout.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWeekperfectringcount()
/*     */     {
/* 343 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 344 */       return WeekPerfectRingCout.this.weekperfectringcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleantime()
/*     */     {
/* 351 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 352 */       return WeekPerfectRingCout.this.cleantime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWeekperfectringcount(int _v_)
/*     */     {
/* 359 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 360 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleantime(long _v_)
/*     */     {
/* 367 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 374 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 375 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 381 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 382 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 388 */       return WeekPerfectRingCout.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 394 */       return WeekPerfectRingCout.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 400 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 407 */       return WeekPerfectRingCout.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 413 */       return WeekPerfectRingCout.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 419 */       WeekPerfectRingCout.this._xdb_verify_unsafe_();
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 426 */       return WeekPerfectRingCout.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 432 */       return WeekPerfectRingCout.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 438 */       return WeekPerfectRingCout.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 444 */       return WeekPerfectRingCout.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 450 */       return WeekPerfectRingCout.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 456 */       return WeekPerfectRingCout.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 462 */       return WeekPerfectRingCout.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.WeekPerfectRingCout
/*     */   {
/*     */     private int weekperfectringcount;
/*     */     
/*     */     private long cleantime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 481 */       this.weekperfectringcount = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.WeekPerfectRingCout _o1_)
/*     */     {
/* 486 */       if ((_o1_ instanceof WeekPerfectRingCout)) { assign((WeekPerfectRingCout)_o1_);
/* 487 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 488 */       } else if ((_o1_ instanceof WeekPerfectRingCout.Const)) assign(((WeekPerfectRingCout.Const)_o1_).nThis()); else {
/* 489 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(WeekPerfectRingCout _o_) {
/* 494 */       this.weekperfectringcount = _o_.weekperfectringcount;
/* 495 */       this.cleantime = _o_.cleantime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 500 */       this.weekperfectringcount = _o_.weekperfectringcount;
/* 501 */       this.cleantime = _o_.cleantime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 507 */       _os_.marshal(this.weekperfectringcount);
/* 508 */       _os_.marshal(this.cleantime);
/* 509 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 515 */       this.weekperfectringcount = _os_.unmarshal_int();
/* 516 */       this.cleantime = _os_.unmarshal_long();
/* 517 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 523 */       int _size_ = 0;
/* 524 */       _size_ += CodedOutputStream.computeInt32Size(1, this.weekperfectringcount);
/* 525 */       _size_ += CodedOutputStream.computeInt64Size(2, this.cleantime);
/* 526 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 534 */         _output_.writeInt32(1, this.weekperfectringcount);
/* 535 */         _output_.writeInt64(2, this.cleantime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 539 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 541 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 549 */         boolean done = false;
/* 550 */         while (!done)
/*     */         {
/* 552 */           int tag = _input_.readTag();
/* 553 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 557 */             done = true;
/* 558 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 562 */             this.weekperfectringcount = _input_.readInt32();
/* 563 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 567 */             this.cleantime = _input_.readInt64();
/* 568 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 574 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 583 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WeekPerfectRingCout copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WeekPerfectRingCout toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.WeekPerfectRingCout toBean()
/*     */     {
/* 606 */       return new WeekPerfectRingCout(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WeekPerfectRingCout toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.WeekPerfectRingCout toBeanIf()
/*     */     {
/* 617 */       return new WeekPerfectRingCout(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 639 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 643 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 647 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWeekperfectringcount()
/*     */     {
/* 654 */       return this.weekperfectringcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleantime()
/*     */     {
/* 661 */       return this.cleantime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWeekperfectringcount(int _v_)
/*     */     {
/* 668 */       this.weekperfectringcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleantime(long _v_)
/*     */     {
/* 675 */       this.cleantime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 681 */       if (!(_o1_ instanceof Data)) return false;
/* 682 */       Data _o_ = (Data)_o1_;
/* 683 */       if (this.weekperfectringcount != _o_.weekperfectringcount) return false;
/* 684 */       if (this.cleantime != _o_.cleantime) return false;
/* 685 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 691 */       int _h_ = 0;
/* 692 */       _h_ += this.weekperfectringcount;
/* 693 */       _h_ = (int)(_h_ + this.cleantime);
/* 694 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 700 */       StringBuilder _sb_ = new StringBuilder();
/* 701 */       _sb_.append("(");
/* 702 */       _sb_.append(this.weekperfectringcount);
/* 703 */       _sb_.append(",");
/* 704 */       _sb_.append(this.cleantime);
/* 705 */       _sb_.append(")");
/* 706 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WeekPerfectRingCout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */