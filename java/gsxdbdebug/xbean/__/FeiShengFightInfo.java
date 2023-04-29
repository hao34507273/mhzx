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
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class FeiShengFightInfo extends XBean implements xbean.FeiShengFightInfo
/*     */ {
/*     */   private SetX<Integer> complete_sortids;
/*     */   private int daily_get_team_member_award_times;
/*     */   private long daily_get_team_member_award_times_timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.complete_sortids.clear();
/*  23 */     this.daily_get_team_member_award_times = 0;
/*  24 */     this.daily_get_team_member_award_times_timestamp = -1L;
/*     */   }
/*     */   
/*     */   FeiShengFightInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.complete_sortids = new SetX();
/*  31 */     this.daily_get_team_member_award_times = 0;
/*  32 */     this.daily_get_team_member_award_times_timestamp = -1L;
/*     */   }
/*     */   
/*     */   public FeiShengFightInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FeiShengFightInfo(FeiShengFightInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FeiShengFightInfo(xbean.FeiShengFightInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof FeiShengFightInfo)) { assign((FeiShengFightInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FeiShengFightInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.complete_sortids = new SetX();
/*  58 */     this.complete_sortids.addAll(_o_.complete_sortids);
/*  59 */     this.daily_get_team_member_award_times = _o_.daily_get_team_member_award_times;
/*  60 */     this.daily_get_team_member_award_times_timestamp = _o_.daily_get_team_member_award_times_timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.complete_sortids = new SetX();
/*  66 */     this.complete_sortids.addAll(_o_.complete_sortids);
/*  67 */     this.daily_get_team_member_award_times = _o_.daily_get_team_member_award_times;
/*  68 */     this.daily_get_team_member_award_times_timestamp = _o_.daily_get_team_member_award_times_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.complete_sortids.size());
/*  76 */     for (Integer _v_ : this.complete_sortids)
/*     */     {
/*  78 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  80 */     _os_.marshal(this.daily_get_team_member_award_times);
/*  81 */     _os_.marshal(this.daily_get_team_member_award_times_timestamp);
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  88 */     _xdb_verify_unsafe_();
/*  89 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  91 */       int _v_ = 0;
/*  92 */       _v_ = _os_.unmarshal_int();
/*  93 */       this.complete_sortids.add(Integer.valueOf(_v_));
/*     */     }
/*  95 */     this.daily_get_team_member_award_times = _os_.unmarshal_int();
/*  96 */     this.daily_get_team_member_award_times_timestamp = _os_.unmarshal_long();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     for (Integer _v_ : this.complete_sortids)
/*     */     {
/* 107 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(2, this.daily_get_team_member_award_times);
/* 110 */     _size_ += CodedOutputStream.computeInt64Size(3, this.daily_get_team_member_award_times_timestamp);
/* 111 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       for (Integer _v_ : this.complete_sortids)
/*     */       {
/* 122 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 124 */       _output_.writeInt32(2, this.daily_get_team_member_award_times);
/* 125 */       _output_.writeInt64(3, this.daily_get_team_member_award_times_timestamp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 129 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 131 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 140 */       boolean done = false;
/* 141 */       while (!done)
/*     */       {
/* 143 */         int tag = _input_.readTag();
/* 144 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 148 */           done = true;
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 153 */           int _v_ = 0;
/* 154 */           _v_ = _input_.readInt32();
/* 155 */           this.complete_sortids.add(Integer.valueOf(_v_));
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 160 */           this.daily_get_team_member_award_times = _input_.readInt32();
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 165 */           this.daily_get_team_member_award_times_timestamp = _input_.readInt64();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 170 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 172 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 181 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 185 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 187 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeiShengFightInfo copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new FeiShengFightInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeiShengFightInfo toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FeiShengFightInfo toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new FeiShengFightInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeiShengFightInfo toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FeiShengFightInfo toBeanIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getComplete_sortids()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return xdb.Logs.logSet(new LogKey(this, "complete_sortids"), this.complete_sortids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getComplete_sortidsAsData()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/*     */     
/* 243 */     FeiShengFightInfo _o_ = this;
/* 244 */     Set<Integer> complete_sortids = new SetX();
/* 245 */     complete_sortids.addAll(_o_.complete_sortids);
/* 246 */     return complete_sortids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDaily_get_team_member_award_times()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.daily_get_team_member_award_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getDaily_get_team_member_award_times_timestamp()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.daily_get_team_member_award_times_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDaily_get_team_member_award_times(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new LogKey(this, "daily_get_team_member_award_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogInt(this, FeiShengFightInfo.this.daily_get_team_member_award_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             FeiShengFightInfo.this.daily_get_team_member_award_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.daily_get_team_member_award_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDaily_get_team_member_award_times_timestamp(long _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "daily_get_team_member_award_times_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogLong(this, FeiShengFightInfo.this.daily_get_team_member_award_times_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             FeiShengFightInfo.this.daily_get_team_member_award_times_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.daily_get_team_member_award_times_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     FeiShengFightInfo _o_ = null;
/* 312 */     if ((_o1_ instanceof FeiShengFightInfo)) { _o_ = (FeiShengFightInfo)_o1_;
/* 313 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 314 */       return false;
/* 315 */     if (!this.complete_sortids.equals(_o_.complete_sortids)) return false;
/* 316 */     if (this.daily_get_team_member_award_times != _o_.daily_get_team_member_award_times) return false;
/* 317 */     if (this.daily_get_team_member_award_times_timestamp != _o_.daily_get_team_member_award_times_timestamp) return false;
/* 318 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     int _h_ = 0;
/* 326 */     _h_ += this.complete_sortids.hashCode();
/* 327 */     _h_ += this.daily_get_team_member_award_times;
/* 328 */     _h_ = (int)(_h_ + this.daily_get_team_member_award_times_timestamp);
/* 329 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     StringBuilder _sb_ = new StringBuilder();
/* 337 */     _sb_.append("(");
/* 338 */     _sb_.append(this.complete_sortids);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.daily_get_team_member_award_times);
/* 341 */     _sb_.append(",");
/* 342 */     _sb_.append(this.daily_get_team_member_award_times_timestamp);
/* 343 */     _sb_.append(")");
/* 344 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 350 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 351 */     lb.add(new xdb.logs.ListenableSet().setVarName("complete_sortids"));
/* 352 */     lb.add(new xdb.logs.ListenableChanged().setVarName("daily_get_team_member_award_times"));
/* 353 */     lb.add(new xdb.logs.ListenableChanged().setVarName("daily_get_team_member_award_times_timestamp"));
/* 354 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FeiShengFightInfo {
/*     */     private Const() {}
/*     */     
/*     */     FeiShengFightInfo nThis() {
/* 361 */       return FeiShengFightInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengFightInfo copy()
/*     */     {
/* 373 */       return FeiShengFightInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengFightInfo toData()
/*     */     {
/* 379 */       return FeiShengFightInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FeiShengFightInfo toBean()
/*     */     {
/* 384 */       return FeiShengFightInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengFightInfo toDataIf()
/*     */     {
/* 390 */       return FeiShengFightInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FeiShengFightInfo toBeanIf()
/*     */     {
/* 395 */       return FeiShengFightInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getComplete_sortids()
/*     */     {
/* 402 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 403 */       return xdb.Consts.constSet(FeiShengFightInfo.this.complete_sortids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getComplete_sortidsAsData()
/*     */     {
/* 409 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/*     */       
/* 411 */       FeiShengFightInfo _o_ = FeiShengFightInfo.this;
/* 412 */       Set<Integer> complete_sortids = new SetX();
/* 413 */       complete_sortids.addAll(_o_.complete_sortids);
/* 414 */       return complete_sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDaily_get_team_member_award_times()
/*     */     {
/* 421 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 422 */       return FeiShengFightInfo.this.daily_get_team_member_award_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDaily_get_team_member_award_times_timestamp()
/*     */     {
/* 429 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 430 */       return FeiShengFightInfo.this.daily_get_team_member_award_times_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDaily_get_team_member_award_times(int _v_)
/*     */     {
/* 437 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDaily_get_team_member_award_times_timestamp(long _v_)
/*     */     {
/* 445 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 446 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 452 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 453 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 459 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 460 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 466 */       return FeiShengFightInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 472 */       return FeiShengFightInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 478 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 485 */       return FeiShengFightInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 491 */       return FeiShengFightInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 497 */       FeiShengFightInfo.this._xdb_verify_unsafe_();
/* 498 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 504 */       return FeiShengFightInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 510 */       return FeiShengFightInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 516 */       return FeiShengFightInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 522 */       return FeiShengFightInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 528 */       return FeiShengFightInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 534 */       return FeiShengFightInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 540 */       return FeiShengFightInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FeiShengFightInfo
/*     */   {
/*     */     private HashSet<Integer> complete_sortids;
/*     */     
/*     */     private int daily_get_team_member_award_times;
/*     */     
/*     */     private long daily_get_team_member_award_times_timestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 561 */       this.complete_sortids = new HashSet();
/* 562 */       this.daily_get_team_member_award_times = 0;
/* 563 */       this.daily_get_team_member_award_times_timestamp = -1L;
/*     */     }
/*     */     
/*     */     Data(xbean.FeiShengFightInfo _o1_)
/*     */     {
/* 568 */       if ((_o1_ instanceof FeiShengFightInfo)) { assign((FeiShengFightInfo)_o1_);
/* 569 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 570 */       } else if ((_o1_ instanceof FeiShengFightInfo.Const)) assign(((FeiShengFightInfo.Const)_o1_).nThis()); else {
/* 571 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FeiShengFightInfo _o_) {
/* 576 */       this.complete_sortids = new HashSet();
/* 577 */       this.complete_sortids.addAll(_o_.complete_sortids);
/* 578 */       this.daily_get_team_member_award_times = _o_.daily_get_team_member_award_times;
/* 579 */       this.daily_get_team_member_award_times_timestamp = _o_.daily_get_team_member_award_times_timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 584 */       this.complete_sortids = new HashSet();
/* 585 */       this.complete_sortids.addAll(_o_.complete_sortids);
/* 586 */       this.daily_get_team_member_award_times = _o_.daily_get_team_member_award_times;
/* 587 */       this.daily_get_team_member_award_times_timestamp = _o_.daily_get_team_member_award_times_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 593 */       _os_.compact_uint32(this.complete_sortids.size());
/* 594 */       for (Integer _v_ : this.complete_sortids)
/*     */       {
/* 596 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 598 */       _os_.marshal(this.daily_get_team_member_award_times);
/* 599 */       _os_.marshal(this.daily_get_team_member_award_times_timestamp);
/* 600 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 606 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 608 */         int _v_ = 0;
/* 609 */         _v_ = _os_.unmarshal_int();
/* 610 */         this.complete_sortids.add(Integer.valueOf(_v_));
/*     */       }
/* 612 */       this.daily_get_team_member_award_times = _os_.unmarshal_int();
/* 613 */       this.daily_get_team_member_award_times_timestamp = _os_.unmarshal_long();
/* 614 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 620 */       int _size_ = 0;
/* 621 */       for (Integer _v_ : this.complete_sortids)
/*     */       {
/* 623 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 625 */       _size_ += CodedOutputStream.computeInt32Size(2, this.daily_get_team_member_award_times);
/* 626 */       _size_ += CodedOutputStream.computeInt64Size(3, this.daily_get_team_member_award_times_timestamp);
/* 627 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 635 */         for (Integer _v_ : this.complete_sortids)
/*     */         {
/* 637 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 639 */         _output_.writeInt32(2, this.daily_get_team_member_award_times);
/* 640 */         _output_.writeInt64(3, this.daily_get_team_member_award_times_timestamp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 644 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 646 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 654 */         boolean done = false;
/* 655 */         while (!done)
/*     */         {
/* 657 */           int tag = _input_.readTag();
/* 658 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 662 */             done = true;
/* 663 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 667 */             int _v_ = 0;
/* 668 */             _v_ = _input_.readInt32();
/* 669 */             this.complete_sortids.add(Integer.valueOf(_v_));
/* 670 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 674 */             this.daily_get_team_member_award_times = _input_.readInt32();
/* 675 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 679 */             this.daily_get_team_member_award_times_timestamp = _input_.readInt64();
/* 680 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 684 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 686 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 695 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 699 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 701 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengFightInfo copy()
/*     */     {
/* 707 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengFightInfo toData()
/*     */     {
/* 713 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FeiShengFightInfo toBean()
/*     */     {
/* 718 */       return new FeiShengFightInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeiShengFightInfo toDataIf()
/*     */     {
/* 724 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FeiShengFightInfo toBeanIf()
/*     */     {
/* 729 */       return new FeiShengFightInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 735 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 739 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 743 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 747 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 751 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 755 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 759 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getComplete_sortids()
/*     */     {
/* 766 */       return this.complete_sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getComplete_sortidsAsData()
/*     */     {
/* 773 */       return this.complete_sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDaily_get_team_member_award_times()
/*     */     {
/* 780 */       return this.daily_get_team_member_award_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDaily_get_team_member_award_times_timestamp()
/*     */     {
/* 787 */       return this.daily_get_team_member_award_times_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDaily_get_team_member_award_times(int _v_)
/*     */     {
/* 794 */       this.daily_get_team_member_award_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDaily_get_team_member_award_times_timestamp(long _v_)
/*     */     {
/* 801 */       this.daily_get_team_member_award_times_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 807 */       if (!(_o1_ instanceof Data)) return false;
/* 808 */       Data _o_ = (Data)_o1_;
/* 809 */       if (!this.complete_sortids.equals(_o_.complete_sortids)) return false;
/* 810 */       if (this.daily_get_team_member_award_times != _o_.daily_get_team_member_award_times) return false;
/* 811 */       if (this.daily_get_team_member_award_times_timestamp != _o_.daily_get_team_member_award_times_timestamp) return false;
/* 812 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 818 */       int _h_ = 0;
/* 819 */       _h_ += this.complete_sortids.hashCode();
/* 820 */       _h_ += this.daily_get_team_member_award_times;
/* 821 */       _h_ = (int)(_h_ + this.daily_get_team_member_award_times_timestamp);
/* 822 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 828 */       StringBuilder _sb_ = new StringBuilder();
/* 829 */       _sb_.append("(");
/* 830 */       _sb_.append(this.complete_sortids);
/* 831 */       _sb_.append(",");
/* 832 */       _sb_.append(this.daily_get_team_member_award_times);
/* 833 */       _sb_.append(",");
/* 834 */       _sb_.append(this.daily_get_team_member_award_times_timestamp);
/* 835 */       _sb_.append(")");
/* 836 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FeiShengFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */