/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class PetArenaRankBackup extends XBean implements xbean.PetArenaRankBackup
/*     */ {
/*     */   private HashMap<Long, Integer> role_ranks;
/*     */   private HashMap<Long, Integer> awards;
/*     */   private long award_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.role_ranks.clear();
/*  23 */     this.awards.clear();
/*  24 */     this.award_time = 0L;
/*     */   }
/*     */   
/*     */   PetArenaRankBackup(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.role_ranks = new HashMap();
/*  31 */     this.awards = new HashMap();
/*     */   }
/*     */   
/*     */   public PetArenaRankBackup()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetArenaRankBackup(PetArenaRankBackup _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetArenaRankBackup(xbean.PetArenaRankBackup _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof PetArenaRankBackup)) { assign((PetArenaRankBackup)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PetArenaRankBackup _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.role_ranks = new HashMap();
/*  57 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/*  58 */       this.role_ranks.put(_e_.getKey(), _e_.getValue());
/*  59 */     this.awards = new HashMap();
/*  60 */     for (Map.Entry<Long, Integer> _e_ : _o_.awards.entrySet())
/*  61 */       this.awards.put(_e_.getKey(), _e_.getValue());
/*  62 */     this.award_time = _o_.award_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.role_ranks = new HashMap();
/*  68 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/*  69 */       this.role_ranks.put(_e_.getKey(), _e_.getValue());
/*  70 */     this.awards = new HashMap();
/*  71 */     for (Map.Entry<Long, Integer> _e_ : _o_.awards.entrySet())
/*  72 */       this.awards.put(_e_.getKey(), _e_.getValue());
/*  73 */     this.award_time = _o_.award_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.role_ranks.size());
/*  81 */     for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  84 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  86 */     _os_.compact_uint32(this.awards.size());
/*  87 */     for (Map.Entry<Long, Integer> _e_ : this.awards.entrySet())
/*     */     {
/*  89 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  90 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  92 */     _os_.marshal(this.award_time);
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     
/* 101 */     int size = _os_.uncompact_uint32();
/* 102 */     if (size >= 12)
/*     */     {
/* 104 */       this.role_ranks = new HashMap(size * 2);
/*     */     }
/* 106 */     for (; size > 0; size--)
/*     */     {
/* 108 */       long _k_ = 0L;
/* 109 */       _k_ = _os_.unmarshal_long();
/* 110 */       int _v_ = 0;
/* 111 */       _v_ = _os_.unmarshal_int();
/* 112 */       this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/*     */ 
/* 116 */     int size = _os_.uncompact_uint32();
/* 117 */     if (size >= 12)
/*     */     {
/* 119 */       this.awards = new HashMap(size * 2);
/*     */     }
/* 121 */     for (; size > 0; size--)
/*     */     {
/* 123 */       long _k_ = 0L;
/* 124 */       _k_ = _os_.unmarshal_long();
/* 125 */       int _v_ = 0;
/* 126 */       _v_ = _os_.unmarshal_int();
/* 127 */       this.awards.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 130 */     this.award_time = _os_.unmarshal_long();
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */     {
/* 141 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 142 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 144 */     for (Map.Entry<Long, Integer> _e_ : this.awards.entrySet())
/*     */     {
/* 146 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 147 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 149 */     _size_ += CodedOutputStream.computeInt64Size(3, this.award_time);
/* 150 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 159 */       for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */       {
/* 161 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 162 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 164 */       for (Map.Entry<Long, Integer> _e_ : this.awards.entrySet())
/*     */       {
/* 166 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 167 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 169 */       _output_.writeInt64(3, this.award_time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 175 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 184 */       boolean done = false;
/* 185 */       while (!done)
/*     */       {
/* 187 */         int tag = _input_.readTag();
/* 188 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 192 */           done = true;
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 197 */           long _k_ = 0L;
/* 198 */           _k_ = _input_.readInt64();
/* 199 */           int readTag = _input_.readTag();
/* 200 */           if (8 != readTag)
/*     */           {
/* 202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 204 */           int _v_ = 0;
/* 205 */           _v_ = _input_.readInt32();
/* 206 */           this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 207 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 211 */           long _k_ = 0L;
/* 212 */           _k_ = _input_.readInt64();
/* 213 */           int readTag = _input_.readTag();
/* 214 */           if (16 != readTag)
/*     */           {
/* 216 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 218 */           int _v_ = 0;
/* 219 */           _v_ = _input_.readInt32();
/* 220 */           this.awards.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 221 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 225 */           this.award_time = _input_.readInt64();
/* 226 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 230 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 232 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 241 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 247 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaRankBackup copy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new PetArenaRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaRankBackup toData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetArenaRankBackup toBean()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new PetArenaRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaRankBackup toDataIf()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetArenaRankBackup toBeanIf()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getRole_ranks()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return xdb.Logs.logMap(new LogKey(this, "role_ranks"), this.role_ranks);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getRole_ranksAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     PetArenaRankBackup _o_ = this;
/* 305 */     Map<Long, Integer> role_ranks = new HashMap();
/* 306 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/* 307 */       role_ranks.put(_e_.getKey(), _e_.getValue());
/* 308 */     return role_ranks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getAwards()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     return xdb.Logs.logMap(new LogKey(this, "awards"), this.awards);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getAwardsAsData()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/*     */     
/* 325 */     PetArenaRankBackup _o_ = this;
/* 326 */     Map<Long, Integer> awards = new HashMap();
/* 327 */     for (Map.Entry<Long, Integer> _e_ : _o_.awards.entrySet())
/* 328 */       awards.put(_e_.getKey(), _e_.getValue());
/* 329 */     return awards;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAward_time()
/*     */   {
/* 336 */     _xdb_verify_unsafe_();
/* 337 */     return this.award_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_time(long _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new LogKey(this, "award_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 349 */         new xdb.logs.LogLong(this, PetArenaRankBackup.this.award_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             PetArenaRankBackup.this.award_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.award_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     PetArenaRankBackup _o_ = null;
/* 366 */     if ((_o1_ instanceof PetArenaRankBackup)) { _o_ = (PetArenaRankBackup)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (!this.role_ranks.equals(_o_.role_ranks)) return false;
/* 370 */     if (!this.awards.equals(_o_.awards)) return false;
/* 371 */     if (this.award_time != _o_.award_time) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ += this.role_ranks.hashCode();
/* 381 */     _h_ += this.awards.hashCode();
/* 382 */     _h_ = (int)(_h_ + this.award_time);
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.role_ranks);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.awards);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.award_time);
/* 397 */     _sb_.append(")");
/* 398 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 404 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 405 */     lb.add(new xdb.logs.ListenableMap().setVarName("role_ranks"));
/* 406 */     lb.add(new xdb.logs.ListenableMap().setVarName("awards"));
/* 407 */     lb.add(new xdb.logs.ListenableChanged().setVarName("award_time"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetArenaRankBackup {
/*     */     private Const() {}
/*     */     
/*     */     PetArenaRankBackup nThis() {
/* 415 */       return PetArenaRankBackup.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRankBackup copy()
/*     */     {
/* 427 */       return PetArenaRankBackup.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRankBackup toData()
/*     */     {
/* 433 */       return PetArenaRankBackup.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRankBackup toBean()
/*     */     {
/* 438 */       return PetArenaRankBackup.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRankBackup toDataIf()
/*     */     {
/* 444 */       return PetArenaRankBackup.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRankBackup toBeanIf()
/*     */     {
/* 449 */       return PetArenaRankBackup.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranks()
/*     */     {
/* 456 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 457 */       return xdb.Consts.constMap(PetArenaRankBackup.this.role_ranks);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranksAsData()
/*     */     {
/* 464 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/*     */       
/* 466 */       PetArenaRankBackup _o_ = PetArenaRankBackup.this;
/* 467 */       Map<Long, Integer> role_ranks = new HashMap();
/* 468 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/* 469 */         role_ranks.put(_e_.getKey(), _e_.getValue());
/* 470 */       return role_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getAwards()
/*     */     {
/* 477 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 478 */       return xdb.Consts.constMap(PetArenaRankBackup.this.awards);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getAwardsAsData()
/*     */     {
/* 485 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/*     */       
/* 487 */       PetArenaRankBackup _o_ = PetArenaRankBackup.this;
/* 488 */       Map<Long, Integer> awards = new HashMap();
/* 489 */       for (Map.Entry<Long, Integer> _e_ : _o_.awards.entrySet())
/* 490 */         awards.put(_e_.getKey(), _e_.getValue());
/* 491 */       return awards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAward_time()
/*     */     {
/* 498 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 499 */       return PetArenaRankBackup.this.award_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_time(long _v_)
/*     */     {
/* 506 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 513 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 514 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 520 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 521 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 527 */       return PetArenaRankBackup.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 533 */       return PetArenaRankBackup.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 546 */       return PetArenaRankBackup.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 552 */       return PetArenaRankBackup.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 558 */       PetArenaRankBackup.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 565 */       return PetArenaRankBackup.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 571 */       return PetArenaRankBackup.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 577 */       return PetArenaRankBackup.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 583 */       return PetArenaRankBackup.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 589 */       return PetArenaRankBackup.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 595 */       return PetArenaRankBackup.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 601 */       return PetArenaRankBackup.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetArenaRankBackup
/*     */   {
/*     */     private HashMap<Long, Integer> role_ranks;
/*     */     
/*     */     private HashMap<Long, Integer> awards;
/*     */     
/*     */     private long award_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.role_ranks = new HashMap();
/* 623 */       this.awards = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.PetArenaRankBackup _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof PetArenaRankBackup)) { assign((PetArenaRankBackup)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof PetArenaRankBackup.Const)) assign(((PetArenaRankBackup.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PetArenaRankBackup _o_) {
/* 636 */       this.role_ranks = new HashMap();
/* 637 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/* 638 */         this.role_ranks.put(_e_.getKey(), _e_.getValue());
/* 639 */       this.awards = new HashMap();
/* 640 */       for (Map.Entry<Long, Integer> _e_ : _o_.awards.entrySet())
/* 641 */         this.awards.put(_e_.getKey(), _e_.getValue());
/* 642 */       this.award_time = _o_.award_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 647 */       this.role_ranks = new HashMap();
/* 648 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/* 649 */         this.role_ranks.put(_e_.getKey(), _e_.getValue());
/* 650 */       this.awards = new HashMap();
/* 651 */       for (Map.Entry<Long, Integer> _e_ : _o_.awards.entrySet())
/* 652 */         this.awards.put(_e_.getKey(), _e_.getValue());
/* 653 */       this.award_time = _o_.award_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.compact_uint32(this.role_ranks.size());
/* 660 */       for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 663 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 665 */       _os_.compact_uint32(this.awards.size());
/* 666 */       for (Map.Entry<Long, Integer> _e_ : this.awards.entrySet())
/*     */       {
/* 668 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 669 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 671 */       _os_.marshal(this.award_time);
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 679 */       int size = _os_.uncompact_uint32();
/* 680 */       if (size >= 12)
/*     */       {
/* 682 */         this.role_ranks = new HashMap(size * 2);
/*     */       }
/* 684 */       for (; size > 0; size--)
/*     */       {
/* 686 */         long _k_ = 0L;
/* 687 */         _k_ = _os_.unmarshal_long();
/* 688 */         int _v_ = 0;
/* 689 */         _v_ = _os_.unmarshal_int();
/* 690 */         this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/*     */ 
/* 694 */       int size = _os_.uncompact_uint32();
/* 695 */       if (size >= 12)
/*     */       {
/* 697 */         this.awards = new HashMap(size * 2);
/*     */       }
/* 699 */       for (; size > 0; size--)
/*     */       {
/* 701 */         long _k_ = 0L;
/* 702 */         _k_ = _os_.unmarshal_long();
/* 703 */         int _v_ = 0;
/* 704 */         _v_ = _os_.unmarshal_int();
/* 705 */         this.awards.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 708 */       this.award_time = _os_.unmarshal_long();
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */       {
/* 718 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 719 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 721 */       for (Map.Entry<Long, Integer> _e_ : this.awards.entrySet())
/*     */       {
/* 723 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 724 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 726 */       _size_ += CodedOutputStream.computeInt64Size(3, this.award_time);
/* 727 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 735 */         for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */         {
/* 737 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 738 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 740 */         for (Map.Entry<Long, Integer> _e_ : this.awards.entrySet())
/*     */         {
/* 742 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 743 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 745 */         _output_.writeInt64(3, this.award_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 749 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 751 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 759 */         boolean done = false;
/* 760 */         while (!done)
/*     */         {
/* 762 */           int tag = _input_.readTag();
/* 763 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 767 */             done = true;
/* 768 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 772 */             long _k_ = 0L;
/* 773 */             _k_ = _input_.readInt64();
/* 774 */             int readTag = _input_.readTag();
/* 775 */             if (8 != readTag)
/*     */             {
/* 777 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 779 */             int _v_ = 0;
/* 780 */             _v_ = _input_.readInt32();
/* 781 */             this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 786 */             long _k_ = 0L;
/* 787 */             _k_ = _input_.readInt64();
/* 788 */             int readTag = _input_.readTag();
/* 789 */             if (16 != readTag)
/*     */             {
/* 791 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 793 */             int _v_ = 0;
/* 794 */             _v_ = _input_.readInt32();
/* 795 */             this.awards.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 796 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 800 */             this.award_time = _input_.readInt64();
/* 801 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 805 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 807 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 816 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 820 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 822 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRankBackup copy()
/*     */     {
/* 828 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRankBackup toData()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRankBackup toBean()
/*     */     {
/* 839 */       return new PetArenaRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRankBackup toDataIf()
/*     */     {
/* 845 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRankBackup toBeanIf()
/*     */     {
/* 850 */       return new PetArenaRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 872 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 876 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 880 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranks()
/*     */     {
/* 887 */       return this.role_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranksAsData()
/*     */     {
/* 894 */       return this.role_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getAwards()
/*     */     {
/* 901 */       return this.awards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getAwardsAsData()
/*     */     {
/* 908 */       return this.awards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAward_time()
/*     */     {
/* 915 */       return this.award_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_time(long _v_)
/*     */     {
/* 922 */       this.award_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 928 */       if (!(_o1_ instanceof Data)) return false;
/* 929 */       Data _o_ = (Data)_o1_;
/* 930 */       if (!this.role_ranks.equals(_o_.role_ranks)) return false;
/* 931 */       if (!this.awards.equals(_o_.awards)) return false;
/* 932 */       if (this.award_time != _o_.award_time) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.role_ranks.hashCode();
/* 941 */       _h_ += this.awards.hashCode();
/* 942 */       _h_ = (int)(_h_ + this.award_time);
/* 943 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 949 */       StringBuilder _sb_ = new StringBuilder();
/* 950 */       _sb_.append("(");
/* 951 */       _sb_.append(this.role_ranks);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.awards);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.award_time);
/* 956 */       _sb_.append(")");
/* 957 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetArenaRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */