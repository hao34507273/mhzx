/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class PetArenaRank extends xdb.XBean implements xbean.PetArenaRank
/*     */ {
/*     */   private ArrayList<xbean.PetArenaRankInfo> ranks;
/*     */   private HashMap<Long, Integer> roles;
/*     */   private SetX<Long> merged_roles;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.ranks.clear();
/*  23 */     this.roles.clear();
/*  24 */     this.merged_roles.clear();
/*     */   }
/*     */   
/*     */   PetArenaRank(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.ranks = new ArrayList();
/*  31 */     this.roles = new HashMap();
/*  32 */     this.merged_roles = new SetX();
/*     */   }
/*     */   
/*     */   public PetArenaRank()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetArenaRank(PetArenaRank _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetArenaRank(xbean.PetArenaRank _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof PetArenaRank)) { assign((PetArenaRank)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PetArenaRank _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.ranks = new ArrayList();
/*  58 */     for (xbean.PetArenaRankInfo _v_ : _o_.ranks)
/*  59 */       this.ranks.add(new PetArenaRankInfo(_v_, this, "ranks"));
/*  60 */     this.roles = new HashMap();
/*  61 */     for (Map.Entry<Long, Integer> _e_ : _o_.roles.entrySet())
/*  62 */       this.roles.put(_e_.getKey(), _e_.getValue());
/*  63 */     this.merged_roles = new SetX();
/*  64 */     this.merged_roles.addAll(_o_.merged_roles);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.ranks = new ArrayList();
/*  70 */     for (xbean.PetArenaRankInfo _v_ : _o_.ranks)
/*  71 */       this.ranks.add(new PetArenaRankInfo(_v_, this, "ranks"));
/*  72 */     this.roles = new HashMap();
/*  73 */     for (Map.Entry<Long, Integer> _e_ : _o_.roles.entrySet())
/*  74 */       this.roles.put(_e_.getKey(), _e_.getValue());
/*  75 */     this.merged_roles = new SetX();
/*  76 */     this.merged_roles.addAll(_o_.merged_roles);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     _os_.compact_uint32(this.ranks.size());
/*  84 */     for (xbean.PetArenaRankInfo _v_ : this.ranks)
/*     */     {
/*  86 */       _v_.marshal(_os_);
/*     */     }
/*  88 */     _os_.compact_uint32(this.roles.size());
/*  89 */     for (Map.Entry<Long, Integer> _e_ : this.roles.entrySet())
/*     */     {
/*  91 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  92 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  94 */     _os_.compact_uint32(this.merged_roles.size());
/*  95 */     for (Long _v_ : this.merged_roles)
/*     */     {
/*  97 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     _xdb_verify_unsafe_();
/* 106 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 108 */       xbean.PetArenaRankInfo _v_ = new PetArenaRankInfo(0, this, "ranks");
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.ranks.add(_v_);
/*     */     }
/*     */     
/* 113 */     int size = _os_.uncompact_uint32();
/* 114 */     if (size >= 12)
/*     */     {
/* 116 */       this.roles = new HashMap(size * 2);
/*     */     }
/* 118 */     for (; size > 0; size--)
/*     */     {
/* 120 */       long _k_ = 0L;
/* 121 */       _k_ = _os_.unmarshal_long();
/* 122 */       int _v_ = 0;
/* 123 */       _v_ = _os_.unmarshal_int();
/* 124 */       this.roles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 127 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 129 */       long _v_ = 0L;
/* 130 */       _v_ = _os_.unmarshal_long();
/* 131 */       this.merged_roles.add(Long.valueOf(_v_));
/*     */     }
/* 133 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 139 */     _xdb_verify_unsafe_();
/* 140 */     int _size_ = 0;
/* 141 */     for (xbean.PetArenaRankInfo _v_ : this.ranks)
/*     */     {
/* 143 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 145 */     for (Map.Entry<Long, Integer> _e_ : this.roles.entrySet())
/*     */     {
/* 147 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 148 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 150 */     for (Long _v_ : this.merged_roles)
/*     */     {
/* 152 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */     }
/* 154 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 160 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 163 */       for (xbean.PetArenaRankInfo _v_ : this.ranks)
/*     */       {
/* 165 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 167 */       for (Map.Entry<Long, Integer> _e_ : this.roles.entrySet())
/*     */       {
/* 169 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 170 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 172 */       for (Long _v_ : this.merged_roles)
/*     */       {
/* 174 */         _output_.writeInt64(3, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 181 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 190 */       boolean done = false;
/* 191 */       while (!done)
/*     */       {
/* 193 */         int tag = _input_.readTag();
/* 194 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 198 */           done = true;
/* 199 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 203 */           xbean.PetArenaRankInfo _v_ = new PetArenaRankInfo(0, this, "ranks");
/* 204 */           _input_.readMessage(_v_);
/* 205 */           this.ranks.add(_v_);
/* 206 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 210 */           long _k_ = 0L;
/* 211 */           _k_ = _input_.readInt64();
/* 212 */           int readTag = _input_.readTag();
/* 213 */           if (16 != readTag)
/*     */           {
/* 215 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 217 */           int _v_ = 0;
/* 218 */           _v_ = _input_.readInt32();
/* 219 */           this.roles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 220 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 224 */           long _v_ = 0L;
/* 225 */           _v_ = _input_.readInt64();
/* 226 */           this.merged_roles.add(Long.valueOf(_v_));
/* 227 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 231 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 233 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 242 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 246 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 248 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaRank copy()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return new PetArenaRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaRank toData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetArenaRank toBean()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return new PetArenaRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetArenaRank toDataIf()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetArenaRank toBeanIf()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/* 288 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.List<xbean.PetArenaRankInfo> getRanks()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return xdb.Logs.logList(new xdb.LogKey(this, "ranks"), this.ranks);
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<xbean.PetArenaRankInfo> getRanksAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     PetArenaRank _o_ = this;
/* 305 */     java.util.List<xbean.PetArenaRankInfo> ranks = new ArrayList();
/* 306 */     for (xbean.PetArenaRankInfo _v_ : _o_.ranks)
/* 307 */       ranks.add(new PetArenaRankInfo.Data(_v_));
/* 308 */     return ranks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, Integer> getRoles()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     return xdb.Logs.logMap(new xdb.LogKey(this, "roles"), this.roles);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, Integer> getRolesAsData()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/*     */     
/* 325 */     PetArenaRank _o_ = this;
/* 326 */     java.util.Map<Long, Integer> roles = new HashMap();
/* 327 */     for (Map.Entry<Long, Integer> _e_ : _o_.roles.entrySet())
/* 328 */       roles.put(_e_.getKey(), _e_.getValue());
/* 329 */     return roles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getMerged_roles()
/*     */   {
/* 336 */     _xdb_verify_unsafe_();
/* 337 */     return xdb.Logs.logSet(new xdb.LogKey(this, "merged_roles"), this.merged_roles);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getMerged_rolesAsData()
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/*     */     
/* 345 */     PetArenaRank _o_ = this;
/* 346 */     Set<Long> merged_roles = new SetX();
/* 347 */     merged_roles.addAll(_o_.merged_roles);
/* 348 */     return merged_roles;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     PetArenaRank _o_ = null;
/* 356 */     if ((_o1_ instanceof PetArenaRank)) { _o_ = (PetArenaRank)_o1_;
/* 357 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 358 */       return false;
/* 359 */     if (!this.ranks.equals(_o_.ranks)) return false;
/* 360 */     if (!this.roles.equals(_o_.roles)) return false;
/* 361 */     if (!this.merged_roles.equals(_o_.merged_roles)) return false;
/* 362 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     int _h_ = 0;
/* 370 */     _h_ += this.ranks.hashCode();
/* 371 */     _h_ += this.roles.hashCode();
/* 372 */     _h_ += this.merged_roles.hashCode();
/* 373 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 379 */     _xdb_verify_unsafe_();
/* 380 */     StringBuilder _sb_ = new StringBuilder();
/* 381 */     _sb_.append("(");
/* 382 */     _sb_.append(this.ranks);
/* 383 */     _sb_.append(",");
/* 384 */     _sb_.append(this.roles);
/* 385 */     _sb_.append(",");
/* 386 */     _sb_.append(this.merged_roles);
/* 387 */     _sb_.append(")");
/* 388 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 394 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 395 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ranks"));
/* 396 */     lb.add(new xdb.logs.ListenableMap().setVarName("roles"));
/* 397 */     lb.add(new xdb.logs.ListenableSet().setVarName("merged_roles"));
/* 398 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetArenaRank {
/*     */     private Const() {}
/*     */     
/*     */     PetArenaRank nThis() {
/* 405 */       return PetArenaRank.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 411 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRank copy()
/*     */     {
/* 417 */       return PetArenaRank.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRank toData()
/*     */     {
/* 423 */       return PetArenaRank.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRank toBean()
/*     */     {
/* 428 */       return PetArenaRank.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRank toDataIf()
/*     */     {
/* 434 */       return PetArenaRank.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRank toBeanIf()
/*     */     {
/* 439 */       return PetArenaRank.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<xbean.PetArenaRankInfo> getRanks()
/*     */     {
/* 446 */       PetArenaRank.this._xdb_verify_unsafe_();
/* 447 */       return xdb.Consts.constList(PetArenaRank.this.ranks);
/*     */     }
/*     */     
/*     */ 
/*     */     public java.util.List<xbean.PetArenaRankInfo> getRanksAsData()
/*     */     {
/* 453 */       PetArenaRank.this._xdb_verify_unsafe_();
/*     */       
/* 455 */       PetArenaRank _o_ = PetArenaRank.this;
/* 456 */       java.util.List<xbean.PetArenaRankInfo> ranks = new ArrayList();
/* 457 */       for (xbean.PetArenaRankInfo _v_ : _o_.ranks)
/* 458 */         ranks.add(new PetArenaRankInfo.Data(_v_));
/* 459 */       return ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRoles()
/*     */     {
/* 466 */       PetArenaRank.this._xdb_verify_unsafe_();
/* 467 */       return xdb.Consts.constMap(PetArenaRank.this.roles);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRolesAsData()
/*     */     {
/* 474 */       PetArenaRank.this._xdb_verify_unsafe_();
/*     */       
/* 476 */       PetArenaRank _o_ = PetArenaRank.this;
/* 477 */       java.util.Map<Long, Integer> roles = new HashMap();
/* 478 */       for (Map.Entry<Long, Integer> _e_ : _o_.roles.entrySet())
/* 479 */         roles.put(_e_.getKey(), _e_.getValue());
/* 480 */       return roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getMerged_roles()
/*     */     {
/* 487 */       PetArenaRank.this._xdb_verify_unsafe_();
/* 488 */       return xdb.Consts.constSet(PetArenaRank.this.merged_roles);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getMerged_rolesAsData()
/*     */     {
/* 494 */       PetArenaRank.this._xdb_verify_unsafe_();
/*     */       
/* 496 */       PetArenaRank _o_ = PetArenaRank.this;
/* 497 */       Set<Long> merged_roles = new SetX();
/* 498 */       merged_roles.addAll(_o_.merged_roles);
/* 499 */       return merged_roles;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 505 */       PetArenaRank.this._xdb_verify_unsafe_();
/* 506 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 512 */       PetArenaRank.this._xdb_verify_unsafe_();
/* 513 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 519 */       return PetArenaRank.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 525 */       return PetArenaRank.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 531 */       PetArenaRank.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 538 */       return PetArenaRank.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 544 */       return PetArenaRank.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       PetArenaRank.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 557 */       return PetArenaRank.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 563 */       return PetArenaRank.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 569 */       return PetArenaRank.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 575 */       return PetArenaRank.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 581 */       return PetArenaRank.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 587 */       return PetArenaRank.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 593 */       return PetArenaRank.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetArenaRank
/*     */   {
/*     */     private ArrayList<xbean.PetArenaRankInfo> ranks;
/*     */     
/*     */     private HashMap<Long, Integer> roles;
/*     */     
/*     */     private HashSet<Long> merged_roles;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 609 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 614 */       this.ranks = new ArrayList();
/* 615 */       this.roles = new HashMap();
/* 616 */       this.merged_roles = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.PetArenaRank _o1_)
/*     */     {
/* 621 */       if ((_o1_ instanceof PetArenaRank)) { assign((PetArenaRank)_o1_);
/* 622 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 623 */       } else if ((_o1_ instanceof PetArenaRank.Const)) assign(((PetArenaRank.Const)_o1_).nThis()); else {
/* 624 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PetArenaRank _o_) {
/* 629 */       this.ranks = new ArrayList();
/* 630 */       for (xbean.PetArenaRankInfo _v_ : _o_.ranks)
/* 631 */         this.ranks.add(new PetArenaRankInfo.Data(_v_));
/* 632 */       this.roles = new HashMap();
/* 633 */       for (Map.Entry<Long, Integer> _e_ : _o_.roles.entrySet())
/* 634 */         this.roles.put(_e_.getKey(), _e_.getValue());
/* 635 */       this.merged_roles = new HashSet();
/* 636 */       this.merged_roles.addAll(_o_.merged_roles);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 641 */       this.ranks = new ArrayList();
/* 642 */       for (xbean.PetArenaRankInfo _v_ : _o_.ranks)
/* 643 */         this.ranks.add(new PetArenaRankInfo.Data(_v_));
/* 644 */       this.roles = new HashMap();
/* 645 */       for (Map.Entry<Long, Integer> _e_ : _o_.roles.entrySet())
/* 646 */         this.roles.put(_e_.getKey(), _e_.getValue());
/* 647 */       this.merged_roles = new HashSet();
/* 648 */       this.merged_roles.addAll(_o_.merged_roles);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 654 */       _os_.compact_uint32(this.ranks.size());
/* 655 */       for (xbean.PetArenaRankInfo _v_ : this.ranks)
/*     */       {
/* 657 */         _v_.marshal(_os_);
/*     */       }
/* 659 */       _os_.compact_uint32(this.roles.size());
/* 660 */       for (Map.Entry<Long, Integer> _e_ : this.roles.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 663 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 665 */       _os_.compact_uint32(this.merged_roles.size());
/* 666 */       for (Long _v_ : this.merged_roles)
/*     */       {
/* 668 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 670 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 676 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 678 */         xbean.PetArenaRankInfo _v_ = xbean.Pod.newPetArenaRankInfoData();
/* 679 */         _v_.unmarshal(_os_);
/* 680 */         this.ranks.add(_v_);
/*     */       }
/*     */       
/* 683 */       int size = _os_.uncompact_uint32();
/* 684 */       if (size >= 12)
/*     */       {
/* 686 */         this.roles = new HashMap(size * 2);
/*     */       }
/* 688 */       for (; size > 0; size--)
/*     */       {
/* 690 */         long _k_ = 0L;
/* 691 */         _k_ = _os_.unmarshal_long();
/* 692 */         int _v_ = 0;
/* 693 */         _v_ = _os_.unmarshal_int();
/* 694 */         this.roles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 697 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 699 */         long _v_ = 0L;
/* 700 */         _v_ = _os_.unmarshal_long();
/* 701 */         this.merged_roles.add(Long.valueOf(_v_));
/*     */       }
/* 703 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 709 */       int _size_ = 0;
/* 710 */       for (xbean.PetArenaRankInfo _v_ : this.ranks)
/*     */       {
/* 712 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 714 */       for (Map.Entry<Long, Integer> _e_ : this.roles.entrySet())
/*     */       {
/* 716 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 717 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 719 */       for (Long _v_ : this.merged_roles)
/*     */       {
/* 721 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */       }
/* 723 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 731 */         for (xbean.PetArenaRankInfo _v_ : this.ranks)
/*     */         {
/* 733 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 735 */         for (Map.Entry<Long, Integer> _e_ : this.roles.entrySet())
/*     */         {
/* 737 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 738 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 740 */         for (Long _v_ : this.merged_roles)
/*     */         {
/* 742 */           _output_.writeInt64(3, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 747 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 749 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 757 */         boolean done = false;
/* 758 */         while (!done)
/*     */         {
/* 760 */           int tag = _input_.readTag();
/* 761 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 765 */             done = true;
/* 766 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 770 */             xbean.PetArenaRankInfo _v_ = xbean.Pod.newPetArenaRankInfoData();
/* 771 */             _input_.readMessage(_v_);
/* 772 */             this.ranks.add(_v_);
/* 773 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 777 */             long _k_ = 0L;
/* 778 */             _k_ = _input_.readInt64();
/* 779 */             int readTag = _input_.readTag();
/* 780 */             if (16 != readTag)
/*     */             {
/* 782 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 784 */             int _v_ = 0;
/* 785 */             _v_ = _input_.readInt32();
/* 786 */             this.roles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 791 */             long _v_ = 0L;
/* 792 */             _v_ = _input_.readInt64();
/* 793 */             this.merged_roles.add(Long.valueOf(_v_));
/* 794 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 798 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 800 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 809 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 813 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 815 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRank copy()
/*     */     {
/* 821 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRank toData()
/*     */     {
/* 827 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRank toBean()
/*     */     {
/* 832 */       return new PetArenaRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetArenaRank toDataIf()
/*     */     {
/* 838 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetArenaRank toBeanIf()
/*     */     {
/* 843 */       return new PetArenaRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 849 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 853 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 857 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 861 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 865 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 869 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 873 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<xbean.PetArenaRankInfo> getRanks()
/*     */     {
/* 880 */       return this.ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<xbean.PetArenaRankInfo> getRanksAsData()
/*     */     {
/* 887 */       return this.ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRoles()
/*     */     {
/* 894 */       return this.roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, Integer> getRolesAsData()
/*     */     {
/* 901 */       return this.roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getMerged_roles()
/*     */     {
/* 908 */       return this.merged_roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getMerged_rolesAsData()
/*     */     {
/* 915 */       return this.merged_roles;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 921 */       if (!(_o1_ instanceof Data)) return false;
/* 922 */       Data _o_ = (Data)_o1_;
/* 923 */       if (!this.ranks.equals(_o_.ranks)) return false;
/* 924 */       if (!this.roles.equals(_o_.roles)) return false;
/* 925 */       if (!this.merged_roles.equals(_o_.merged_roles)) return false;
/* 926 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 932 */       int _h_ = 0;
/* 933 */       _h_ += this.ranks.hashCode();
/* 934 */       _h_ += this.roles.hashCode();
/* 935 */       _h_ += this.merged_roles.hashCode();
/* 936 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 942 */       StringBuilder _sb_ = new StringBuilder();
/* 943 */       _sb_.append("(");
/* 944 */       _sb_.append(this.ranks);
/* 945 */       _sb_.append(",");
/* 946 */       _sb_.append(this.roles);
/* 947 */       _sb_.append(",");
/* 948 */       _sb_.append(this.merged_roles);
/* 949 */       _sb_.append(")");
/* 950 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetArenaRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */