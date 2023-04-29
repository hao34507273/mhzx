/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class RoleDeliveryStatus extends XBean implements xbean.RoleDeliveryStatus
/*     */ {
/*     */   private SetX<Integer> fetched_rewards;
/*     */   private long source_id;
/*     */   private long target_id;
/*     */   private SetX<Integer> notified_rewards;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.fetched_rewards.clear();
/*  25 */     this.source_id = 0L;
/*  26 */     this.target_id = 0L;
/*  27 */     this.notified_rewards.clear();
/*     */   }
/*     */   
/*     */   RoleDeliveryStatus(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.fetched_rewards = new SetX();
/*  34 */     this.notified_rewards = new SetX();
/*     */   }
/*     */   
/*     */   public RoleDeliveryStatus()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleDeliveryStatus(RoleDeliveryStatus _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleDeliveryStatus(xbean.RoleDeliveryStatus _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof RoleDeliveryStatus)) { assign((RoleDeliveryStatus)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleDeliveryStatus _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.fetched_rewards = new SetX();
/*  60 */     this.fetched_rewards.addAll(_o_.fetched_rewards);
/*  61 */     this.source_id = _o_.source_id;
/*  62 */     this.target_id = _o_.target_id;
/*  63 */     this.notified_rewards = new SetX();
/*  64 */     this.notified_rewards.addAll(_o_.notified_rewards);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.fetched_rewards = new SetX();
/*  70 */     this.fetched_rewards.addAll(_o_.fetched_rewards);
/*  71 */     this.source_id = _o_.source_id;
/*  72 */     this.target_id = _o_.target_id;
/*  73 */     this.notified_rewards = new SetX();
/*  74 */     this.notified_rewards.addAll(_o_.notified_rewards);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.compact_uint32(this.fetched_rewards.size());
/*  82 */     for (Integer _v_ : this.fetched_rewards)
/*     */     {
/*  84 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  86 */     _os_.marshal(this.source_id);
/*  87 */     _os_.marshal(this.target_id);
/*  88 */     _os_.compact_uint32(this.notified_rewards.size());
/*  89 */     for (Integer _v_ : this.notified_rewards)
/*     */     {
/*  91 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 102 */       int _v_ = 0;
/* 103 */       _v_ = _os_.unmarshal_int();
/* 104 */       this.fetched_rewards.add(Integer.valueOf(_v_));
/*     */     }
/* 106 */     this.source_id = _os_.unmarshal_long();
/* 107 */     this.target_id = _os_.unmarshal_long();
/* 108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 110 */       int _v_ = 0;
/* 111 */       _v_ = _os_.unmarshal_int();
/* 112 */       this.notified_rewards.add(Integer.valueOf(_v_));
/*     */     }
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     for (Integer _v_ : this.fetched_rewards)
/*     */     {
/* 124 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 126 */     _size_ += CodedOutputStream.computeInt64Size(2, this.source_id);
/* 127 */     _size_ += CodedOutputStream.computeInt64Size(3, this.target_id);
/* 128 */     for (Integer _v_ : this.notified_rewards)
/*     */     {
/* 130 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*     */     }
/* 132 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 138 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 141 */       for (Integer _v_ : this.fetched_rewards)
/*     */       {
/* 143 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 145 */       _output_.writeInt64(2, this.source_id);
/* 146 */       _output_.writeInt64(3, this.target_id);
/* 147 */       for (Integer _v_ : this.notified_rewards)
/*     */       {
/* 149 */         _output_.writeInt32(4, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 154 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 156 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 162 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 165 */       boolean done = false;
/* 166 */       while (!done)
/*     */       {
/* 168 */         int tag = _input_.readTag();
/* 169 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 173 */           done = true;
/* 174 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 178 */           int _v_ = 0;
/* 179 */           _v_ = _input_.readInt32();
/* 180 */           this.fetched_rewards.add(Integer.valueOf(_v_));
/* 181 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 185 */           this.source_id = _input_.readInt64();
/* 186 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 190 */           this.target_id = _input_.readInt64();
/* 191 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 195 */           int _v_ = 0;
/* 196 */           _v_ = _input_.readInt32();
/* 197 */           this.notified_rewards.add(Integer.valueOf(_v_));
/* 198 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 202 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 204 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 213 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 217 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 219 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleDeliveryStatus copy()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new RoleDeliveryStatus(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleDeliveryStatus toData()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleDeliveryStatus toBean()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new RoleDeliveryStatus(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleDeliveryStatus toDataIf()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleDeliveryStatus toBeanIf()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getFetched_rewards()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return xdb.Logs.logSet(new LogKey(this, "fetched_rewards"), this.fetched_rewards);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getFetched_rewardsAsData()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/*     */     
/* 275 */     RoleDeliveryStatus _o_ = this;
/* 276 */     Set<Integer> fetched_rewards = new SetX();
/* 277 */     fetched_rewards.addAll(_o_.fetched_rewards);
/* 278 */     return fetched_rewards;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSource_id()
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     return this.source_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTarget_id()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     return this.target_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getNotified_rewards()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logSet(new LogKey(this, "notified_rewards"), this.notified_rewards);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getNotified_rewardsAsData()
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/*     */     
/* 310 */     RoleDeliveryStatus _o_ = this;
/* 311 */     Set<Integer> notified_rewards = new SetX();
/* 312 */     notified_rewards.addAll(_o_.notified_rewards);
/* 313 */     return notified_rewards;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSource_id(long _v_)
/*     */   {
/* 320 */     _xdb_verify_unsafe_();
/* 321 */     xdb.Logs.logIf(new LogKey(this, "source_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 325 */         new xdb.logs.LogLong(this, RoleDeliveryStatus.this.source_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 329 */             RoleDeliveryStatus.this.source_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 333 */     });
/* 334 */     this.source_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTarget_id(long _v_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     xdb.Logs.logIf(new LogKey(this, "target_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 346 */         new xdb.logs.LogLong(this, RoleDeliveryStatus.this.target_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 350 */             RoleDeliveryStatus.this.target_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 354 */     });
/* 355 */     this.target_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 361 */     _xdb_verify_unsafe_();
/* 362 */     RoleDeliveryStatus _o_ = null;
/* 363 */     if ((_o1_ instanceof RoleDeliveryStatus)) { _o_ = (RoleDeliveryStatus)_o1_;
/* 364 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 365 */       return false;
/* 366 */     if (!this.fetched_rewards.equals(_o_.fetched_rewards)) return false;
/* 367 */     if (this.source_id != _o_.source_id) return false;
/* 368 */     if (this.target_id != _o_.target_id) return false;
/* 369 */     if (!this.notified_rewards.equals(_o_.notified_rewards)) return false;
/* 370 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 376 */     _xdb_verify_unsafe_();
/* 377 */     int _h_ = 0;
/* 378 */     _h_ += this.fetched_rewards.hashCode();
/* 379 */     _h_ = (int)(_h_ + this.source_id);
/* 380 */     _h_ = (int)(_h_ + this.target_id);
/* 381 */     _h_ += this.notified_rewards.hashCode();
/* 382 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 388 */     _xdb_verify_unsafe_();
/* 389 */     StringBuilder _sb_ = new StringBuilder();
/* 390 */     _sb_.append("(");
/* 391 */     _sb_.append(this.fetched_rewards);
/* 392 */     _sb_.append(",");
/* 393 */     _sb_.append(this.source_id);
/* 394 */     _sb_.append(",");
/* 395 */     _sb_.append(this.target_id);
/* 396 */     _sb_.append(",");
/* 397 */     _sb_.append(this.notified_rewards);
/* 398 */     _sb_.append(")");
/* 399 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 405 */     ListenableBean lb = new ListenableBean();
/* 406 */     lb.add(new xdb.logs.ListenableSet().setVarName("fetched_rewards"));
/* 407 */     lb.add(new xdb.logs.ListenableChanged().setVarName("source_id"));
/* 408 */     lb.add(new xdb.logs.ListenableChanged().setVarName("target_id"));
/* 409 */     lb.add(new xdb.logs.ListenableSet().setVarName("notified_rewards"));
/* 410 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleDeliveryStatus {
/*     */     private Const() {}
/*     */     
/*     */     RoleDeliveryStatus nThis() {
/* 417 */       return RoleDeliveryStatus.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleDeliveryStatus copy()
/*     */     {
/* 429 */       return RoleDeliveryStatus.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleDeliveryStatus toData()
/*     */     {
/* 435 */       return RoleDeliveryStatus.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleDeliveryStatus toBean()
/*     */     {
/* 440 */       return RoleDeliveryStatus.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleDeliveryStatus toDataIf()
/*     */     {
/* 446 */       return RoleDeliveryStatus.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleDeliveryStatus toBeanIf()
/*     */     {
/* 451 */       return RoleDeliveryStatus.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getFetched_rewards()
/*     */     {
/* 458 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 459 */       return xdb.Consts.constSet(RoleDeliveryStatus.this.fetched_rewards);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getFetched_rewardsAsData()
/*     */     {
/* 465 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/*     */       
/* 467 */       RoleDeliveryStatus _o_ = RoleDeliveryStatus.this;
/* 468 */       Set<Integer> fetched_rewards = new SetX();
/* 469 */       fetched_rewards.addAll(_o_.fetched_rewards);
/* 470 */       return fetched_rewards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSource_id()
/*     */     {
/* 477 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 478 */       return RoleDeliveryStatus.this.source_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTarget_id()
/*     */     {
/* 485 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 486 */       return RoleDeliveryStatus.this.target_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getNotified_rewards()
/*     */     {
/* 493 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 494 */       return xdb.Consts.constSet(RoleDeliveryStatus.this.notified_rewards);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getNotified_rewardsAsData()
/*     */     {
/* 500 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/*     */       
/* 502 */       RoleDeliveryStatus _o_ = RoleDeliveryStatus.this;
/* 503 */       Set<Integer> notified_rewards = new SetX();
/* 504 */       notified_rewards.addAll(_o_.notified_rewards);
/* 505 */       return notified_rewards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSource_id(long _v_)
/*     */     {
/* 512 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTarget_id(long _v_)
/*     */     {
/* 520 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 527 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 528 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 534 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 535 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 541 */       return RoleDeliveryStatus.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 547 */       return RoleDeliveryStatus.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 553 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 560 */       return RoleDeliveryStatus.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 566 */       return RoleDeliveryStatus.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 572 */       RoleDeliveryStatus.this._xdb_verify_unsafe_();
/* 573 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 579 */       return RoleDeliveryStatus.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 585 */       return RoleDeliveryStatus.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 591 */       return RoleDeliveryStatus.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 597 */       return RoleDeliveryStatus.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 603 */       return RoleDeliveryStatus.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 609 */       return RoleDeliveryStatus.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 615 */       return RoleDeliveryStatus.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleDeliveryStatus
/*     */   {
/*     */     private HashSet<Integer> fetched_rewards;
/*     */     
/*     */     private long source_id;
/*     */     
/*     */     private long target_id;
/*     */     
/*     */     private HashSet<Integer> notified_rewards;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 638 */       this.fetched_rewards = new HashSet();
/* 639 */       this.notified_rewards = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleDeliveryStatus _o1_)
/*     */     {
/* 644 */       if ((_o1_ instanceof RoleDeliveryStatus)) { assign((RoleDeliveryStatus)_o1_);
/* 645 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 646 */       } else if ((_o1_ instanceof RoleDeliveryStatus.Const)) assign(((RoleDeliveryStatus.Const)_o1_).nThis()); else {
/* 647 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleDeliveryStatus _o_) {
/* 652 */       this.fetched_rewards = new HashSet();
/* 653 */       this.fetched_rewards.addAll(_o_.fetched_rewards);
/* 654 */       this.source_id = _o_.source_id;
/* 655 */       this.target_id = _o_.target_id;
/* 656 */       this.notified_rewards = new HashSet();
/* 657 */       this.notified_rewards.addAll(_o_.notified_rewards);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 662 */       this.fetched_rewards = new HashSet();
/* 663 */       this.fetched_rewards.addAll(_o_.fetched_rewards);
/* 664 */       this.source_id = _o_.source_id;
/* 665 */       this.target_id = _o_.target_id;
/* 666 */       this.notified_rewards = new HashSet();
/* 667 */       this.notified_rewards.addAll(_o_.notified_rewards);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 673 */       _os_.compact_uint32(this.fetched_rewards.size());
/* 674 */       for (Integer _v_ : this.fetched_rewards)
/*     */       {
/* 676 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 678 */       _os_.marshal(this.source_id);
/* 679 */       _os_.marshal(this.target_id);
/* 680 */       _os_.compact_uint32(this.notified_rewards.size());
/* 681 */       for (Integer _v_ : this.notified_rewards)
/*     */       {
/* 683 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 685 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 691 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 693 */         int _v_ = 0;
/* 694 */         _v_ = _os_.unmarshal_int();
/* 695 */         this.fetched_rewards.add(Integer.valueOf(_v_));
/*     */       }
/* 697 */       this.source_id = _os_.unmarshal_long();
/* 698 */       this.target_id = _os_.unmarshal_long();
/* 699 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 701 */         int _v_ = 0;
/* 702 */         _v_ = _os_.unmarshal_int();
/* 703 */         this.notified_rewards.add(Integer.valueOf(_v_));
/*     */       }
/* 705 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 711 */       int _size_ = 0;
/* 712 */       for (Integer _v_ : this.fetched_rewards)
/*     */       {
/* 714 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 716 */       _size_ += CodedOutputStream.computeInt64Size(2, this.source_id);
/* 717 */       _size_ += CodedOutputStream.computeInt64Size(3, this.target_id);
/* 718 */       for (Integer _v_ : this.notified_rewards)
/*     */       {
/* 720 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*     */       }
/* 722 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 730 */         for (Integer _v_ : this.fetched_rewards)
/*     */         {
/* 732 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 734 */         _output_.writeInt64(2, this.source_id);
/* 735 */         _output_.writeInt64(3, this.target_id);
/* 736 */         for (Integer _v_ : this.notified_rewards)
/*     */         {
/* 738 */           _output_.writeInt32(4, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 753 */         boolean done = false;
/* 754 */         while (!done)
/*     */         {
/* 756 */           int tag = _input_.readTag();
/* 757 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 761 */             done = true;
/* 762 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 766 */             int _v_ = 0;
/* 767 */             _v_ = _input_.readInt32();
/* 768 */             this.fetched_rewards.add(Integer.valueOf(_v_));
/* 769 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 773 */             this.source_id = _input_.readInt64();
/* 774 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 778 */             this.target_id = _input_.readInt64();
/* 779 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 783 */             int _v_ = 0;
/* 784 */             _v_ = _input_.readInt32();
/* 785 */             this.notified_rewards.add(Integer.valueOf(_v_));
/* 786 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 790 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 792 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 801 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 805 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 807 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleDeliveryStatus copy()
/*     */     {
/* 813 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleDeliveryStatus toData()
/*     */     {
/* 819 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleDeliveryStatus toBean()
/*     */     {
/* 824 */       return new RoleDeliveryStatus(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleDeliveryStatus toDataIf()
/*     */     {
/* 830 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleDeliveryStatus toBeanIf()
/*     */     {
/* 835 */       return new RoleDeliveryStatus(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 841 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 845 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 849 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 853 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 857 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 861 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 865 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getFetched_rewards()
/*     */     {
/* 872 */       return this.fetched_rewards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getFetched_rewardsAsData()
/*     */     {
/* 879 */       return this.fetched_rewards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSource_id()
/*     */     {
/* 886 */       return this.source_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTarget_id()
/*     */     {
/* 893 */       return this.target_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getNotified_rewards()
/*     */     {
/* 900 */       return this.notified_rewards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getNotified_rewardsAsData()
/*     */     {
/* 907 */       return this.notified_rewards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSource_id(long _v_)
/*     */     {
/* 914 */       this.source_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTarget_id(long _v_)
/*     */     {
/* 921 */       this.target_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 927 */       if (!(_o1_ instanceof Data)) return false;
/* 928 */       Data _o_ = (Data)_o1_;
/* 929 */       if (!this.fetched_rewards.equals(_o_.fetched_rewards)) return false;
/* 930 */       if (this.source_id != _o_.source_id) return false;
/* 931 */       if (this.target_id != _o_.target_id) return false;
/* 932 */       if (!this.notified_rewards.equals(_o_.notified_rewards)) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.fetched_rewards.hashCode();
/* 941 */       _h_ = (int)(_h_ + this.source_id);
/* 942 */       _h_ = (int)(_h_ + this.target_id);
/* 943 */       _h_ += this.notified_rewards.hashCode();
/* 944 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 950 */       StringBuilder _sb_ = new StringBuilder();
/* 951 */       _sb_.append("(");
/* 952 */       _sb_.append(this.fetched_rewards);
/* 953 */       _sb_.append(",");
/* 954 */       _sb_.append(this.source_id);
/* 955 */       _sb_.append(",");
/* 956 */       _sb_.append(this.target_id);
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append(this.notified_rewards);
/* 959 */       _sb_.append(")");
/* 960 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleDeliveryStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */