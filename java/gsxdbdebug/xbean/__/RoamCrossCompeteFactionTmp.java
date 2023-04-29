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
/*     */ public final class RoamCrossCompeteFactionTmp extends XBean implements xbean.RoamCrossCompeteFactionTmp
/*     */ {
/*     */   private long world;
/*     */   private SetX<Long> roles;
/*     */   private SetX<Long> fights;
/*     */   private int mapid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.world = -1L;
/*  25 */     this.roles.clear();
/*  26 */     this.fights.clear();
/*  27 */     this.mapid = 0;
/*     */   }
/*     */   
/*     */   RoamCrossCompeteFactionTmp(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.world = -1L;
/*  34 */     this.roles = new SetX();
/*  35 */     this.fights = new SetX();
/*     */   }
/*     */   
/*     */   public RoamCrossCompeteFactionTmp()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoamCrossCompeteFactionTmp(RoamCrossCompeteFactionTmp _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoamCrossCompeteFactionTmp(xbean.RoamCrossCompeteFactionTmp _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof RoamCrossCompeteFactionTmp)) { assign((RoamCrossCompeteFactionTmp)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoamCrossCompeteFactionTmp _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.world = _o_.world;
/*  61 */     this.roles = new SetX();
/*  62 */     this.roles.addAll(_o_.roles);
/*  63 */     this.fights = new SetX();
/*  64 */     this.fights.addAll(_o_.fights);
/*  65 */     this.mapid = _o_.mapid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  70 */     this.world = _o_.world;
/*  71 */     this.roles = new SetX();
/*  72 */     this.roles.addAll(_o_.roles);
/*  73 */     this.fights = new SetX();
/*  74 */     this.fights.addAll(_o_.fights);
/*  75 */     this.mapid = _o_.mapid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     _os_.marshal(this.world);
/*  83 */     _os_.compact_uint32(this.roles.size());
/*  84 */     for (Long _v_ : this.roles)
/*     */     {
/*  86 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  88 */     _os_.compact_uint32(this.fights.size());
/*  89 */     for (Long _v_ : this.fights)
/*     */     {
/*  91 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  93 */     _os_.marshal(this.mapid);
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     this.world = _os_.unmarshal_long();
/* 102 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 104 */       long _v_ = 0L;
/* 105 */       _v_ = _os_.unmarshal_long();
/* 106 */       this.roles.add(Long.valueOf(_v_));
/*     */     }
/* 108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 110 */       long _v_ = 0L;
/* 111 */       _v_ = _os_.unmarshal_long();
/* 112 */       this.fights.add(Long.valueOf(_v_));
/*     */     }
/* 114 */     this.mapid = _os_.unmarshal_int();
/* 115 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/* 122 */     int _size_ = 0;
/* 123 */     _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/* 124 */     for (Long _v_ : this.roles)
/*     */     {
/* 126 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 128 */     for (Long _v_ : this.fights)
/*     */     {
/* 130 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */     }
/* 132 */     _size_ += CodedOutputStream.computeInt32Size(4, this.mapid);
/* 133 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 139 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 142 */       _output_.writeInt64(1, this.world);
/* 143 */       for (Long _v_ : this.roles)
/*     */       {
/* 145 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/* 147 */       for (Long _v_ : this.fights)
/*     */       {
/* 149 */         _output_.writeInt64(3, _v_.longValue());
/*     */       }
/* 151 */       _output_.writeInt32(4, this.mapid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 155 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 157 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 166 */       boolean done = false;
/* 167 */       while (!done)
/*     */       {
/* 169 */         int tag = _input_.readTag();
/* 170 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 174 */           done = true;
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 179 */           this.world = _input_.readInt64();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 184 */           long _v_ = 0L;
/* 185 */           _v_ = _input_.readInt64();
/* 186 */           this.roles.add(Long.valueOf(_v_));
/* 187 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 191 */           long _v_ = 0L;
/* 192 */           _v_ = _input_.readInt64();
/* 193 */           this.fights.add(Long.valueOf(_v_));
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 198 */           this.mapid = _input_.readInt32();
/* 199 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 205 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 214 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 220 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoamCrossCompeteFactionTmp copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new RoamCrossCompeteFactionTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoamCrossCompeteFactionTmp toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoamCrossCompeteFactionTmp toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new RoamCrossCompeteFactionTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoamCrossCompeteFactionTmp toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoamCrossCompeteFactionTmp toBeanIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getWorld()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return this.world;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getRoles()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return xdb.Logs.logSet(new LogKey(this, "roles"), this.roles);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getRolesAsData()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/*     */     
/* 284 */     RoamCrossCompeteFactionTmp _o_ = this;
/* 285 */     Set<Long> roles = new SetX();
/* 286 */     roles.addAll(_o_.roles);
/* 287 */     return roles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getFights()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return xdb.Logs.logSet(new LogKey(this, "fights"), this.fights);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getFightsAsData()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/*     */     
/* 303 */     RoamCrossCompeteFactionTmp _o_ = this;
/* 304 */     Set<Long> fights = new SetX();
/* 305 */     fights.addAll(_o_.fights);
/* 306 */     return fights;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMapid()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     return this.mapid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorld(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "world")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogLong(this, RoamCrossCompeteFactionTmp.this.world)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             RoamCrossCompeteFactionTmp.this.world = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.world = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMapid(int _v_)
/*     */   {
/* 342 */     _xdb_verify_unsafe_();
/* 343 */     xdb.Logs.logIf(new LogKey(this, "mapid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 347 */         new xdb.logs.LogInt(this, RoamCrossCompeteFactionTmp.this.mapid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 351 */             RoamCrossCompeteFactionTmp.this.mapid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 355 */     });
/* 356 */     this.mapid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 362 */     _xdb_verify_unsafe_();
/* 363 */     RoamCrossCompeteFactionTmp _o_ = null;
/* 364 */     if ((_o1_ instanceof RoamCrossCompeteFactionTmp)) { _o_ = (RoamCrossCompeteFactionTmp)_o1_;
/* 365 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 366 */       return false;
/* 367 */     if (this.world != _o_.world) return false;
/* 368 */     if (!this.roles.equals(_o_.roles)) return false;
/* 369 */     if (!this.fights.equals(_o_.fights)) return false;
/* 370 */     if (this.mapid != _o_.mapid) return false;
/* 371 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 377 */     _xdb_verify_unsafe_();
/* 378 */     int _h_ = 0;
/* 379 */     _h_ = (int)(_h_ + this.world);
/* 380 */     _h_ += this.roles.hashCode();
/* 381 */     _h_ += this.fights.hashCode();
/* 382 */     _h_ += this.mapid;
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.world);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.roles);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.fights);
/* 397 */     _sb_.append(",");
/* 398 */     _sb_.append(this.mapid);
/* 399 */     _sb_.append(")");
/* 400 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 406 */     ListenableBean lb = new ListenableBean();
/* 407 */     lb.add(new xdb.logs.ListenableChanged().setVarName("world"));
/* 408 */     lb.add(new xdb.logs.ListenableSet().setVarName("roles"));
/* 409 */     lb.add(new xdb.logs.ListenableSet().setVarName("fights"));
/* 410 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mapid"));
/* 411 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoamCrossCompeteFactionTmp {
/*     */     private Const() {}
/*     */     
/*     */     RoamCrossCompeteFactionTmp nThis() {
/* 418 */       return RoamCrossCompeteFactionTmp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamCrossCompeteFactionTmp copy()
/*     */     {
/* 430 */       return RoamCrossCompeteFactionTmp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamCrossCompeteFactionTmp toData()
/*     */     {
/* 436 */       return RoamCrossCompeteFactionTmp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoamCrossCompeteFactionTmp toBean()
/*     */     {
/* 441 */       return RoamCrossCompeteFactionTmp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamCrossCompeteFactionTmp toDataIf()
/*     */     {
/* 447 */       return RoamCrossCompeteFactionTmp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoamCrossCompeteFactionTmp toBeanIf()
/*     */     {
/* 452 */       return RoamCrossCompeteFactionTmp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorld()
/*     */     {
/* 459 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 460 */       return RoamCrossCompeteFactionTmp.this.world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRoles()
/*     */     {
/* 467 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 468 */       return xdb.Consts.constSet(RoamCrossCompeteFactionTmp.this.roles);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getRolesAsData()
/*     */     {
/* 474 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/*     */       
/* 476 */       RoamCrossCompeteFactionTmp _o_ = RoamCrossCompeteFactionTmp.this;
/* 477 */       Set<Long> roles = new SetX();
/* 478 */       roles.addAll(_o_.roles);
/* 479 */       return roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFights()
/*     */     {
/* 486 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 487 */       return xdb.Consts.constSet(RoamCrossCompeteFactionTmp.this.fights);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getFightsAsData()
/*     */     {
/* 493 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/*     */       
/* 495 */       RoamCrossCompeteFactionTmp _o_ = RoamCrossCompeteFactionTmp.this;
/* 496 */       Set<Long> fights = new SetX();
/* 497 */       fights.addAll(_o_.fights);
/* 498 */       return fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMapid()
/*     */     {
/* 505 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 506 */       return RoamCrossCompeteFactionTmp.this.mapid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorld(long _v_)
/*     */     {
/* 513 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMapid(int _v_)
/*     */     {
/* 521 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 522 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 528 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 529 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 535 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 536 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 542 */       return RoamCrossCompeteFactionTmp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       return RoamCrossCompeteFactionTmp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 554 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 555 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 561 */       return RoamCrossCompeteFactionTmp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 567 */       return RoamCrossCompeteFactionTmp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 573 */       RoamCrossCompeteFactionTmp.this._xdb_verify_unsafe_();
/* 574 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 580 */       return RoamCrossCompeteFactionTmp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 586 */       return RoamCrossCompeteFactionTmp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 592 */       return RoamCrossCompeteFactionTmp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 598 */       return RoamCrossCompeteFactionTmp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 604 */       return RoamCrossCompeteFactionTmp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 610 */       return RoamCrossCompeteFactionTmp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 616 */       return RoamCrossCompeteFactionTmp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoamCrossCompeteFactionTmp
/*     */   {
/*     */     private long world;
/*     */     
/*     */     private HashSet<Long> roles;
/*     */     
/*     */     private HashSet<Long> fights;
/*     */     
/*     */     private int mapid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 634 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 639 */       this.world = -1L;
/* 640 */       this.roles = new HashSet();
/* 641 */       this.fights = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.RoamCrossCompeteFactionTmp _o1_)
/*     */     {
/* 646 */       if ((_o1_ instanceof RoamCrossCompeteFactionTmp)) { assign((RoamCrossCompeteFactionTmp)_o1_);
/* 647 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 648 */       } else if ((_o1_ instanceof RoamCrossCompeteFactionTmp.Const)) assign(((RoamCrossCompeteFactionTmp.Const)_o1_).nThis()); else {
/* 649 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoamCrossCompeteFactionTmp _o_) {
/* 654 */       this.world = _o_.world;
/* 655 */       this.roles = new HashSet();
/* 656 */       this.roles.addAll(_o_.roles);
/* 657 */       this.fights = new HashSet();
/* 658 */       this.fights.addAll(_o_.fights);
/* 659 */       this.mapid = _o_.mapid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 664 */       this.world = _o_.world;
/* 665 */       this.roles = new HashSet();
/* 666 */       this.roles.addAll(_o_.roles);
/* 667 */       this.fights = new HashSet();
/* 668 */       this.fights.addAll(_o_.fights);
/* 669 */       this.mapid = _o_.mapid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 675 */       _os_.marshal(this.world);
/* 676 */       _os_.compact_uint32(this.roles.size());
/* 677 */       for (Long _v_ : this.roles)
/*     */       {
/* 679 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 681 */       _os_.compact_uint32(this.fights.size());
/* 682 */       for (Long _v_ : this.fights)
/*     */       {
/* 684 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 686 */       _os_.marshal(this.mapid);
/* 687 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 693 */       this.world = _os_.unmarshal_long();
/* 694 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 696 */         long _v_ = 0L;
/* 697 */         _v_ = _os_.unmarshal_long();
/* 698 */         this.roles.add(Long.valueOf(_v_));
/*     */       }
/* 700 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 702 */         long _v_ = 0L;
/* 703 */         _v_ = _os_.unmarshal_long();
/* 704 */         this.fights.add(Long.valueOf(_v_));
/*     */       }
/* 706 */       this.mapid = _os_.unmarshal_int();
/* 707 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 713 */       int _size_ = 0;
/* 714 */       _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/* 715 */       for (Long _v_ : this.roles)
/*     */       {
/* 717 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 719 */       for (Long _v_ : this.fights)
/*     */       {
/* 721 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */       }
/* 723 */       _size_ += CodedOutputStream.computeInt32Size(4, this.mapid);
/* 724 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 732 */         _output_.writeInt64(1, this.world);
/* 733 */         for (Long _v_ : this.roles)
/*     */         {
/* 735 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/* 737 */         for (Long _v_ : this.fights)
/*     */         {
/* 739 */           _output_.writeInt64(3, _v_.longValue());
/*     */         }
/* 741 */         _output_.writeInt32(4, this.mapid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 745 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 747 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 755 */         boolean done = false;
/* 756 */         while (!done)
/*     */         {
/* 758 */           int tag = _input_.readTag();
/* 759 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 763 */             done = true;
/* 764 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 768 */             this.world = _input_.readInt64();
/* 769 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 773 */             long _v_ = 0L;
/* 774 */             _v_ = _input_.readInt64();
/* 775 */             this.roles.add(Long.valueOf(_v_));
/* 776 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 780 */             long _v_ = 0L;
/* 781 */             _v_ = _input_.readInt64();
/* 782 */             this.fights.add(Long.valueOf(_v_));
/* 783 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 787 */             this.mapid = _input_.readInt32();
/* 788 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 792 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 794 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 803 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 807 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 809 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamCrossCompeteFactionTmp copy()
/*     */     {
/* 815 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamCrossCompeteFactionTmp toData()
/*     */     {
/* 821 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoamCrossCompeteFactionTmp toBean()
/*     */     {
/* 826 */       return new RoamCrossCompeteFactionTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamCrossCompeteFactionTmp toDataIf()
/*     */     {
/* 832 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoamCrossCompeteFactionTmp toBeanIf()
/*     */     {
/* 837 */       return new RoamCrossCompeteFactionTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 843 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 847 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 851 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 855 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 859 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 863 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorld()
/*     */     {
/* 874 */       return this.world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRoles()
/*     */     {
/* 881 */       return this.roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRolesAsData()
/*     */     {
/* 888 */       return this.roles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFights()
/*     */     {
/* 895 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFightsAsData()
/*     */     {
/* 902 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMapid()
/*     */     {
/* 909 */       return this.mapid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorld(long _v_)
/*     */     {
/* 916 */       this.world = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMapid(int _v_)
/*     */     {
/* 923 */       this.mapid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 929 */       if (!(_o1_ instanceof Data)) return false;
/* 930 */       Data _o_ = (Data)_o1_;
/* 931 */       if (this.world != _o_.world) return false;
/* 932 */       if (!this.roles.equals(_o_.roles)) return false;
/* 933 */       if (!this.fights.equals(_o_.fights)) return false;
/* 934 */       if (this.mapid != _o_.mapid) return false;
/* 935 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 941 */       int _h_ = 0;
/* 942 */       _h_ = (int)(_h_ + this.world);
/* 943 */       _h_ += this.roles.hashCode();
/* 944 */       _h_ += this.fights.hashCode();
/* 945 */       _h_ += this.mapid;
/* 946 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 952 */       StringBuilder _sb_ = new StringBuilder();
/* 953 */       _sb_.append("(");
/* 954 */       _sb_.append(this.world);
/* 955 */       _sb_.append(",");
/* 956 */       _sb_.append(this.roles);
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append(this.fights);
/* 959 */       _sb_.append(",");
/* 960 */       _sb_.append(this.mapid);
/* 961 */       _sb_.append(")");
/* 962 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoamCrossCompeteFactionTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */