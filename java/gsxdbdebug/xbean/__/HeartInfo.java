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
/*     */ public final class HeartInfo extends XBean implements xbean.HeartInfo
/*     */ {
/*     */   private int triggertime;
/*     */   private long lastchecktime;
/*     */   private long otherroleid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.triggertime = 0;
/*  23 */     this.lastchecktime = 0L;
/*  24 */     this.otherroleid = 0L;
/*     */   }
/*     */   
/*     */   HeartInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public HeartInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public HeartInfo(HeartInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   HeartInfo(xbean.HeartInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof HeartInfo)) { assign((HeartInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(HeartInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.triggertime = _o_.triggertime;
/*  55 */     this.lastchecktime = _o_.lastchecktime;
/*  56 */     this.otherroleid = _o_.otherroleid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.triggertime = _o_.triggertime;
/*  62 */     this.lastchecktime = _o_.lastchecktime;
/*  63 */     this.otherroleid = _o_.otherroleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.triggertime);
/*  71 */     _os_.marshal(this.lastchecktime);
/*  72 */     _os_.marshal(this.otherroleid);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.triggertime = _os_.unmarshal_int();
/*  81 */     this.lastchecktime = _os_.unmarshal_long();
/*  82 */     this.otherroleid = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.triggertime);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.lastchecktime);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.otherroleid);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.triggertime);
/* 104 */       _output_.writeInt64(2, this.lastchecktime);
/* 105 */       _output_.writeInt64(3, this.otherroleid);
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
/* 133 */           this.triggertime = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.lastchecktime = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.otherroleid = _input_.readInt64();
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
/*     */   public xbean.HeartInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new HeartInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HeartInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HeartInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new HeartInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HeartInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HeartInfo toBeanIf()
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
/*     */   public int getTriggertime()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.triggertime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLastchecktime()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.lastchecktime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getOtherroleid()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.otherroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTriggertime(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "triggertime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, HeartInfo.this.triggertime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             HeartInfo.this.triggertime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.triggertime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastchecktime(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "lastchecktime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, HeartInfo.this.lastchecktime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             HeartInfo.this.lastchecktime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.lastchecktime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOtherroleid(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "otherroleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, HeartInfo.this.otherroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             HeartInfo.this.otherroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.otherroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     HeartInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof HeartInfo)) { _o_ = (HeartInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.triggertime != _o_.triggertime) return false;
/* 304 */     if (this.lastchecktime != _o_.lastchecktime) return false;
/* 305 */     if (this.otherroleid != _o_.otherroleid) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.triggertime;
/* 315 */     _h_ = (int)(_h_ + this.lastchecktime);
/* 316 */     _h_ = (int)(_h_ + this.otherroleid);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.triggertime);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.lastchecktime);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.otherroleid);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("triggertime"));
/* 340 */     lb.add(new ListenableChanged().setVarName("lastchecktime"));
/* 341 */     lb.add(new ListenableChanged().setVarName("otherroleid"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.HeartInfo {
/*     */     private Const() {}
/*     */     
/*     */     HeartInfo nThis() {
/* 349 */       return HeartInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartInfo copy()
/*     */     {
/* 361 */       return HeartInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartInfo toData()
/*     */     {
/* 367 */       return HeartInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.HeartInfo toBean()
/*     */     {
/* 372 */       return HeartInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartInfo toDataIf()
/*     */     {
/* 378 */       return HeartInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.HeartInfo toBeanIf()
/*     */     {
/* 383 */       return HeartInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTriggertime()
/*     */     {
/* 390 */       HeartInfo.this._xdb_verify_unsafe_();
/* 391 */       return HeartInfo.this.triggertime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastchecktime()
/*     */     {
/* 398 */       HeartInfo.this._xdb_verify_unsafe_();
/* 399 */       return HeartInfo.this.lastchecktime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getOtherroleid()
/*     */     {
/* 406 */       HeartInfo.this._xdb_verify_unsafe_();
/* 407 */       return HeartInfo.this.otherroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTriggertime(int _v_)
/*     */     {
/* 414 */       HeartInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastchecktime(long _v_)
/*     */     {
/* 422 */       HeartInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOtherroleid(long _v_)
/*     */     {
/* 430 */       HeartInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       HeartInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       HeartInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return HeartInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return HeartInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       HeartInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return HeartInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return HeartInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       HeartInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return HeartInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return HeartInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return HeartInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return HeartInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return HeartInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return HeartInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return HeartInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.HeartInfo
/*     */   {
/*     */     private int triggertime;
/*     */     
/*     */     private long lastchecktime;
/*     */     
/*     */     private long otherroleid;
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
/*     */     Data(xbean.HeartInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof HeartInfo)) { assign((HeartInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof HeartInfo.Const)) assign(((HeartInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(HeartInfo _o_) {
/* 558 */       this.triggertime = _o_.triggertime;
/* 559 */       this.lastchecktime = _o_.lastchecktime;
/* 560 */       this.otherroleid = _o_.otherroleid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.triggertime = _o_.triggertime;
/* 566 */       this.lastchecktime = _o_.lastchecktime;
/* 567 */       this.otherroleid = _o_.otherroleid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.triggertime);
/* 574 */       _os_.marshal(this.lastchecktime);
/* 575 */       _os_.marshal(this.otherroleid);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.triggertime = _os_.unmarshal_int();
/* 583 */       this.lastchecktime = _os_.unmarshal_long();
/* 584 */       this.otherroleid = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.triggertime);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.lastchecktime);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.otherroleid);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.triggertime);
/* 604 */         _output_.writeInt64(2, this.lastchecktime);
/* 605 */         _output_.writeInt64(3, this.otherroleid);
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
/* 632 */             this.triggertime = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.lastchecktime = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.otherroleid = _input_.readInt64();
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
/*     */     public xbean.HeartInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.HeartInfo toBean()
/*     */     {
/* 681 */       return new HeartInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.HeartInfo toBeanIf()
/*     */     {
/* 692 */       return new HeartInfo(this, null, null);
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
/*     */     public int getTriggertime()
/*     */     {
/* 729 */       return this.triggertime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastchecktime()
/*     */     {
/* 736 */       return this.lastchecktime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getOtherroleid()
/*     */     {
/* 743 */       return this.otherroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTriggertime(int _v_)
/*     */     {
/* 750 */       this.triggertime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastchecktime(long _v_)
/*     */     {
/* 757 */       this.lastchecktime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOtherroleid(long _v_)
/*     */     {
/* 764 */       this.otherroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.triggertime != _o_.triggertime) return false;
/* 773 */       if (this.lastchecktime != _o_.lastchecktime) return false;
/* 774 */       if (this.otherroleid != _o_.otherroleid) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.triggertime;
/* 783 */       _h_ = (int)(_h_ + this.lastchecktime);
/* 784 */       _h_ = (int)(_h_ + this.otherroleid);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.triggertime);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.lastchecktime);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.otherroleid);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HeartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */