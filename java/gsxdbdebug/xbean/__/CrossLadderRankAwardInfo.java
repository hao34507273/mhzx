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
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class CrossLadderRankAwardInfo extends XBean implements xbean.CrossLadderRankAwardInfo
/*     */ {
/*     */   private HashMap<Long, xbean.RoleCrossLadderRankAwardInfo> role_rank_award_infos;
/*     */   private boolean is_data_complete;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.role_rank_award_infos.clear();
/*  21 */     this.is_data_complete = false;
/*     */   }
/*     */   
/*     */   CrossLadderRankAwardInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.role_rank_award_infos = new HashMap();
/*  28 */     this.is_data_complete = false;
/*     */   }
/*     */   
/*     */   public CrossLadderRankAwardInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossLadderRankAwardInfo(CrossLadderRankAwardInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossLadderRankAwardInfo(xbean.CrossLadderRankAwardInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof CrossLadderRankAwardInfo)) { assign((CrossLadderRankAwardInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossLadderRankAwardInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.role_rank_award_infos = new HashMap();
/*  54 */     for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : _o_.role_rank_award_infos.entrySet())
/*  55 */       this.role_rank_award_infos.put(_e_.getKey(), new RoleCrossLadderRankAwardInfo((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue(), this, "role_rank_award_infos"));
/*  56 */     this.is_data_complete = _o_.is_data_complete;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.role_rank_award_infos = new HashMap();
/*  62 */     for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : _o_.role_rank_award_infos.entrySet())
/*  63 */       this.role_rank_award_infos.put(_e_.getKey(), new RoleCrossLadderRankAwardInfo((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue(), this, "role_rank_award_infos"));
/*  64 */     this.is_data_complete = _o_.is_data_complete;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.role_rank_award_infos.size());
/*  72 */     for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : this.role_rank_award_infos.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       ((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     _os_.marshal(this.is_data_complete);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.role_rank_award_infos = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       long _k_ = 0L;
/*  94 */       _k_ = _os_.unmarshal_long();
/*  95 */       xbean.RoleCrossLadderRankAwardInfo _v_ = new RoleCrossLadderRankAwardInfo(0, this, "role_rank_award_infos");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.role_rank_award_infos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     this.is_data_complete = _os_.unmarshal_boolean();
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : this.role_rank_award_infos.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeBoolSize(2, this.is_data_complete);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : this.role_rank_award_infos.entrySet())
/*     */       {
/* 126 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 127 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 129 */       _output_.writeBool(2, this.is_data_complete);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           long _k_ = 0L;
/* 158 */           _k_ = _input_.readInt64();
/* 159 */           int readTag = _input_.readTag();
/* 160 */           if (10 != readTag)
/*     */           {
/* 162 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 164 */           xbean.RoleCrossLadderRankAwardInfo _v_ = new RoleCrossLadderRankAwardInfo(0, this, "role_rank_award_infos");
/* 165 */           _input_.readMessage(_v_);
/* 166 */           this.role_rank_award_infos.put(Long.valueOf(_k_), _v_);
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           this.is_data_complete = _input_.readBool();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRankAwardInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new CrossLadderRankAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRankAwardInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderRankAwardInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new CrossLadderRankAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRankAwardInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderRankAwardInfo toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.RoleCrossLadderRankAwardInfo> getRole_rank_award_infos()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logMap(new xdb.LogKey(this, "role_rank_award_infos"), this.role_rank_award_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.RoleCrossLadderRankAwardInfo> getRole_rank_award_infosAsData()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/*     */     
/* 250 */     CrossLadderRankAwardInfo _o_ = this;
/* 251 */     Map<Long, xbean.RoleCrossLadderRankAwardInfo> role_rank_award_infos = new HashMap();
/* 252 */     for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : _o_.role_rank_award_infos.entrySet())
/* 253 */       role_rank_award_infos.put(_e_.getKey(), new RoleCrossLadderRankAwardInfo.Data((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue()));
/* 254 */     return role_rank_award_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_data_complete()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.is_data_complete;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_data_complete(boolean _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "is_data_complete")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogObject(this, Boolean.valueOf(CrossLadderRankAwardInfo.this.is_data_complete))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             CrossLadderRankAwardInfo.this.is_data_complete = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.is_data_complete = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     CrossLadderRankAwardInfo _o_ = null;
/* 291 */     if ((_o1_ instanceof CrossLadderRankAwardInfo)) { _o_ = (CrossLadderRankAwardInfo)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (!this.role_rank_award_infos.equals(_o_.role_rank_award_infos)) return false;
/* 295 */     if (this.is_data_complete != _o_.is_data_complete) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.role_rank_award_infos.hashCode();
/* 305 */     _h_ += (this.is_data_complete ? 1231 : 1237);
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.role_rank_award_infos);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.is_data_complete);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("role_rank_award_infos"));
/* 327 */     lb.add(new xdb.logs.ListenableChanged().setVarName("is_data_complete"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossLadderRankAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     CrossLadderRankAwardInfo nThis() {
/* 335 */       return CrossLadderRankAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankAwardInfo copy()
/*     */     {
/* 347 */       return CrossLadderRankAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankAwardInfo toData()
/*     */     {
/* 353 */       return CrossLadderRankAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankAwardInfo toBean()
/*     */     {
/* 358 */       return CrossLadderRankAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankAwardInfo toDataIf()
/*     */     {
/* 364 */       return CrossLadderRankAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankAwardInfo toBeanIf()
/*     */     {
/* 369 */       return CrossLadderRankAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.RoleCrossLadderRankAwardInfo> getRole_rank_award_infos()
/*     */     {
/* 376 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/* 377 */       return xdb.Consts.constMap(CrossLadderRankAwardInfo.this.role_rank_award_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.RoleCrossLadderRankAwardInfo> getRole_rank_award_infosAsData()
/*     */     {
/* 384 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/*     */       
/* 386 */       CrossLadderRankAwardInfo _o_ = CrossLadderRankAwardInfo.this;
/* 387 */       Map<Long, xbean.RoleCrossLadderRankAwardInfo> role_rank_award_infos = new HashMap();
/* 388 */       for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : _o_.role_rank_award_infos.entrySet())
/* 389 */         role_rank_award_infos.put(_e_.getKey(), new RoleCrossLadderRankAwardInfo.Data((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue()));
/* 390 */       return role_rank_award_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_data_complete()
/*     */     {
/* 397 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/* 398 */       return CrossLadderRankAwardInfo.this.is_data_complete;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_data_complete(boolean _v_)
/*     */     {
/* 405 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return CrossLadderRankAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return CrossLadderRankAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return CrossLadderRankAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return CrossLadderRankAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       CrossLadderRankAwardInfo.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return CrossLadderRankAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return CrossLadderRankAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return CrossLadderRankAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return CrossLadderRankAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return CrossLadderRankAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return CrossLadderRankAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return CrossLadderRankAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossLadderRankAwardInfo
/*     */   {
/*     */     private HashMap<Long, xbean.RoleCrossLadderRankAwardInfo> role_rank_award_infos;
/*     */     
/*     */     private boolean is_data_complete;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.role_rank_award_infos = new HashMap();
/* 520 */       this.is_data_complete = false;
/*     */     }
/*     */     
/*     */     Data(xbean.CrossLadderRankAwardInfo _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof CrossLadderRankAwardInfo)) { assign((CrossLadderRankAwardInfo)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof CrossLadderRankAwardInfo.Const)) assign(((CrossLadderRankAwardInfo.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossLadderRankAwardInfo _o_) {
/* 533 */       this.role_rank_award_infos = new HashMap();
/* 534 */       for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : _o_.role_rank_award_infos.entrySet())
/* 535 */         this.role_rank_award_infos.put(_e_.getKey(), new RoleCrossLadderRankAwardInfo.Data((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue()));
/* 536 */       this.is_data_complete = _o_.is_data_complete;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.role_rank_award_infos = new HashMap();
/* 542 */       for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : _o_.role_rank_award_infos.entrySet())
/* 543 */         this.role_rank_award_infos.put(_e_.getKey(), new RoleCrossLadderRankAwardInfo.Data((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue()));
/* 544 */       this.is_data_complete = _o_.is_data_complete;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.compact_uint32(this.role_rank_award_infos.size());
/* 551 */       for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : this.role_rank_award_infos.entrySet())
/*     */       {
/* 553 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 554 */         ((xbean.RoleCrossLadderRankAwardInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 556 */       _os_.marshal(this.is_data_complete);
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 564 */       int size = _os_.uncompact_uint32();
/* 565 */       if (size >= 12)
/*     */       {
/* 567 */         this.role_rank_award_infos = new HashMap(size * 2);
/*     */       }
/* 569 */       for (; size > 0; size--)
/*     */       {
/* 571 */         long _k_ = 0L;
/* 572 */         _k_ = _os_.unmarshal_long();
/* 573 */         xbean.RoleCrossLadderRankAwardInfo _v_ = xbean.Pod.newRoleCrossLadderRankAwardInfoData();
/* 574 */         _v_.unmarshal(_os_);
/* 575 */         this.role_rank_award_infos.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 578 */       this.is_data_complete = _os_.unmarshal_boolean();
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : this.role_rank_award_infos.entrySet())
/*     */       {
/* 588 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 589 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 591 */       _size_ += CodedOutputStream.computeBoolSize(2, this.is_data_complete);
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (Map.Entry<Long, xbean.RoleCrossLadderRankAwardInfo> _e_ : this.role_rank_award_infos.entrySet())
/*     */         {
/* 602 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 603 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 605 */         _output_.writeBool(2, this.is_data_complete);
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
/* 632 */             long _k_ = 0L;
/* 633 */             _k_ = _input_.readInt64();
/* 634 */             int readTag = _input_.readTag();
/* 635 */             if (10 != readTag)
/*     */             {
/* 637 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 639 */             xbean.RoleCrossLadderRankAwardInfo _v_ = xbean.Pod.newRoleCrossLadderRankAwardInfoData();
/* 640 */             _input_.readMessage(_v_);
/* 641 */             this.role_rank_award_infos.put(Long.valueOf(_k_), _v_);
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 646 */             this.is_data_complete = _input_.readBool();
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankAwardInfo copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankAwardInfo toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankAwardInfo toBean()
/*     */     {
/* 685 */       return new CrossLadderRankAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankAwardInfo toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankAwardInfo toBeanIf()
/*     */     {
/* 696 */       return new CrossLadderRankAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.RoleCrossLadderRankAwardInfo> getRole_rank_award_infos()
/*     */     {
/* 733 */       return this.role_rank_award_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.RoleCrossLadderRankAwardInfo> getRole_rank_award_infosAsData()
/*     */     {
/* 740 */       return this.role_rank_award_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_data_complete()
/*     */     {
/* 747 */       return this.is_data_complete;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_data_complete(boolean _v_)
/*     */     {
/* 754 */       this.is_data_complete = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (!this.role_rank_award_infos.equals(_o_.role_rank_award_infos)) return false;
/* 763 */       if (this.is_data_complete != _o_.is_data_complete) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.role_rank_award_infos.hashCode();
/* 772 */       _h_ += (this.is_data_complete ? 1231 : 1237);
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.role_rank_award_infos);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.is_data_complete);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossLadderRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */