/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class GroupShoppingInfo extends xdb.XBean implements xbean.GroupShoppingInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.BigGroupShoppingItemInfo> big_group_infos;
/*     */   private HashMap<Integer, xbean.SmallGroupShoppingItemInfo> small_group_infos;
/*     */   private SetX<Long> incompleted_small_groups;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.big_group_infos.clear();
/*  23 */     this.small_group_infos.clear();
/*  24 */     this.incompleted_small_groups.clear();
/*     */   }
/*     */   
/*     */   GroupShoppingInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.big_group_infos = new HashMap();
/*  31 */     this.small_group_infos = new HashMap();
/*  32 */     this.incompleted_small_groups = new SetX();
/*     */   }
/*     */   
/*     */   public GroupShoppingInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GroupShoppingInfo(GroupShoppingInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GroupShoppingInfo(xbean.GroupShoppingInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof GroupShoppingInfo)) { assign((GroupShoppingInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GroupShoppingInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.big_group_infos = new HashMap();
/*  58 */     for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : _o_.big_group_infos.entrySet())
/*  59 */       this.big_group_infos.put(_e_.getKey(), new BigGroupShoppingItemInfo((xbean.BigGroupShoppingItemInfo)_e_.getValue(), this, "big_group_infos"));
/*  60 */     this.small_group_infos = new HashMap();
/*  61 */     for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : _o_.small_group_infos.entrySet())
/*  62 */       this.small_group_infos.put(_e_.getKey(), new SmallGroupShoppingItemInfo((xbean.SmallGroupShoppingItemInfo)_e_.getValue(), this, "small_group_infos"));
/*  63 */     this.incompleted_small_groups = new SetX();
/*  64 */     this.incompleted_small_groups.addAll(_o_.incompleted_small_groups);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.big_group_infos = new HashMap();
/*  70 */     for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : _o_.big_group_infos.entrySet())
/*  71 */       this.big_group_infos.put(_e_.getKey(), new BigGroupShoppingItemInfo((xbean.BigGroupShoppingItemInfo)_e_.getValue(), this, "big_group_infos"));
/*  72 */     this.small_group_infos = new HashMap();
/*  73 */     for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : _o_.small_group_infos.entrySet())
/*  74 */       this.small_group_infos.put(_e_.getKey(), new SmallGroupShoppingItemInfo((xbean.SmallGroupShoppingItemInfo)_e_.getValue(), this, "small_group_infos"));
/*  75 */     this.incompleted_small_groups = new SetX();
/*  76 */     this.incompleted_small_groups.addAll(_o_.incompleted_small_groups);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     _os_.compact_uint32(this.big_group_infos.size());
/*  84 */     for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : this.big_group_infos.entrySet())
/*     */     {
/*  86 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  87 */       ((xbean.BigGroupShoppingItemInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  89 */     _os_.compact_uint32(this.small_group_infos.size());
/*  90 */     for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : this.small_group_infos.entrySet())
/*     */     {
/*  92 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  93 */       ((xbean.SmallGroupShoppingItemInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  95 */     _os_.compact_uint32(this.incompleted_small_groups.size());
/*  96 */     for (Long _v_ : this.incompleted_small_groups)
/*     */     {
/*  98 */       _os_.marshal(_v_.longValue());
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/*     */     
/* 108 */     int size = _os_.uncompact_uint32();
/* 109 */     if (size >= 12)
/*     */     {
/* 111 */       this.big_group_infos = new HashMap(size * 2);
/*     */     }
/* 113 */     for (; size > 0; size--)
/*     */     {
/* 115 */       int _k_ = 0;
/* 116 */       _k_ = _os_.unmarshal_int();
/* 117 */       xbean.BigGroupShoppingItemInfo _v_ = new BigGroupShoppingItemInfo(0, this, "big_group_infos");
/* 118 */       _v_.unmarshal(_os_);
/* 119 */       this.big_group_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 123 */     int size = _os_.uncompact_uint32();
/* 124 */     if (size >= 12)
/*     */     {
/* 126 */       this.small_group_infos = new HashMap(size * 2);
/*     */     }
/* 128 */     for (; size > 0; size--)
/*     */     {
/* 130 */       int _k_ = 0;
/* 131 */       _k_ = _os_.unmarshal_int();
/* 132 */       xbean.SmallGroupShoppingItemInfo _v_ = new SmallGroupShoppingItemInfo(0, this, "small_group_infos");
/* 133 */       _v_.unmarshal(_os_);
/* 134 */       this.small_group_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 137 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 139 */       long _v_ = 0L;
/* 140 */       _v_ = _os_.unmarshal_long();
/* 141 */       this.incompleted_small_groups.add(Long.valueOf(_v_));
/*     */     }
/* 143 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/* 150 */     int _size_ = 0;
/* 151 */     for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : this.big_group_infos.entrySet())
/*     */     {
/* 153 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 154 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 156 */     for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : this.small_group_infos.entrySet())
/*     */     {
/* 158 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 159 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 161 */     for (Long _v_ : this.incompleted_small_groups)
/*     */     {
/* 163 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */     }
/* 165 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 174 */       for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : this.big_group_infos.entrySet())
/*     */       {
/* 176 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 177 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 179 */       for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : this.small_group_infos.entrySet())
/*     */       {
/* 181 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 182 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 184 */       for (Long _v_ : this.incompleted_small_groups)
/*     */       {
/* 186 */         _output_.writeInt64(3, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 202 */       boolean done = false;
/* 203 */       while (!done)
/*     */       {
/* 205 */         int tag = _input_.readTag();
/* 206 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 210 */           done = true;
/* 211 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 215 */           int _k_ = 0;
/* 216 */           _k_ = _input_.readInt32();
/* 217 */           int readTag = _input_.readTag();
/* 218 */           if (10 != readTag)
/*     */           {
/* 220 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 222 */           xbean.BigGroupShoppingItemInfo _v_ = new BigGroupShoppingItemInfo(0, this, "big_group_infos");
/* 223 */           _input_.readMessage(_v_);
/* 224 */           this.big_group_infos.put(Integer.valueOf(_k_), _v_);
/* 225 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 229 */           int _k_ = 0;
/* 230 */           _k_ = _input_.readInt32();
/* 231 */           int readTag = _input_.readTag();
/* 232 */           if (18 != readTag)
/*     */           {
/* 234 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 236 */           xbean.SmallGroupShoppingItemInfo _v_ = new SmallGroupShoppingItemInfo(0, this, "small_group_infos");
/* 237 */           _input_.readMessage(_v_);
/* 238 */           this.small_group_infos.put(Integer.valueOf(_k_), _v_);
/* 239 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 243 */           long _v_ = 0L;
/* 244 */           _v_ = _input_.readInt64();
/* 245 */           this.incompleted_small_groups.add(Long.valueOf(_v_));
/* 246 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 250 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 252 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 261 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 265 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 267 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupShoppingInfo copy()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new GroupShoppingInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupShoppingInfo toData()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GroupShoppingInfo toBean()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     return new GroupShoppingInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupShoppingInfo toDataIf()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GroupShoppingInfo toBeanIf()
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.BigGroupShoppingItemInfo> getBig_group_infos()
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     return xdb.Logs.logMap(new xdb.LogKey(this, "big_group_infos"), this.big_group_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.BigGroupShoppingItemInfo> getBig_group_infosAsData()
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/*     */     
/* 324 */     GroupShoppingInfo _o_ = this;
/* 325 */     Map<Integer, xbean.BigGroupShoppingItemInfo> big_group_infos = new HashMap();
/* 326 */     for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : _o_.big_group_infos.entrySet())
/* 327 */       big_group_infos.put(_e_.getKey(), new BigGroupShoppingItemInfo.Data((xbean.BigGroupShoppingItemInfo)_e_.getValue()));
/* 328 */     return big_group_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.SmallGroupShoppingItemInfo> getSmall_group_infos()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     return xdb.Logs.logMap(new xdb.LogKey(this, "small_group_infos"), this.small_group_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.SmallGroupShoppingItemInfo> getSmall_group_infosAsData()
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/*     */     
/* 345 */     GroupShoppingInfo _o_ = this;
/* 346 */     Map<Integer, xbean.SmallGroupShoppingItemInfo> small_group_infos = new HashMap();
/* 347 */     for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : _o_.small_group_infos.entrySet())
/* 348 */       small_group_infos.put(_e_.getKey(), new SmallGroupShoppingItemInfo.Data((xbean.SmallGroupShoppingItemInfo)_e_.getValue()));
/* 349 */     return small_group_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getIncompleted_small_groups()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     return xdb.Logs.logSet(new xdb.LogKey(this, "incompleted_small_groups"), this.incompleted_small_groups);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getIncompleted_small_groupsAsData()
/*     */   {
/* 363 */     _xdb_verify_unsafe_();
/*     */     
/* 365 */     GroupShoppingInfo _o_ = this;
/* 366 */     Set<Long> incompleted_small_groups = new SetX();
/* 367 */     incompleted_small_groups.addAll(_o_.incompleted_small_groups);
/* 368 */     return incompleted_small_groups;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     GroupShoppingInfo _o_ = null;
/* 376 */     if ((_o1_ instanceof GroupShoppingInfo)) { _o_ = (GroupShoppingInfo)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (!this.big_group_infos.equals(_o_.big_group_infos)) return false;
/* 380 */     if (!this.small_group_infos.equals(_o_.small_group_infos)) return false;
/* 381 */     if (!this.incompleted_small_groups.equals(_o_.incompleted_small_groups)) return false;
/* 382 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 388 */     _xdb_verify_unsafe_();
/* 389 */     int _h_ = 0;
/* 390 */     _h_ += this.big_group_infos.hashCode();
/* 391 */     _h_ += this.small_group_infos.hashCode();
/* 392 */     _h_ += this.incompleted_small_groups.hashCode();
/* 393 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 399 */     _xdb_verify_unsafe_();
/* 400 */     StringBuilder _sb_ = new StringBuilder();
/* 401 */     _sb_.append("(");
/* 402 */     _sb_.append(this.big_group_infos);
/* 403 */     _sb_.append(",");
/* 404 */     _sb_.append(this.small_group_infos);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.incompleted_small_groups);
/* 407 */     _sb_.append(")");
/* 408 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 414 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 415 */     lb.add(new xdb.logs.ListenableMap().setVarName("big_group_infos"));
/* 416 */     lb.add(new xdb.logs.ListenableMap().setVarName("small_group_infos"));
/* 417 */     lb.add(new xdb.logs.ListenableSet().setVarName("incompleted_small_groups"));
/* 418 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GroupShoppingInfo {
/*     */     private Const() {}
/*     */     
/*     */     GroupShoppingInfo nThis() {
/* 425 */       return GroupShoppingInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingInfo copy()
/*     */     {
/* 437 */       return GroupShoppingInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingInfo toData()
/*     */     {
/* 443 */       return GroupShoppingInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingInfo toBean()
/*     */     {
/* 448 */       return GroupShoppingInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingInfo toDataIf()
/*     */     {
/* 454 */       return GroupShoppingInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingInfo toBeanIf()
/*     */     {
/* 459 */       return GroupShoppingInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BigGroupShoppingItemInfo> getBig_group_infos()
/*     */     {
/* 466 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/* 467 */       return xdb.Consts.constMap(GroupShoppingInfo.this.big_group_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BigGroupShoppingItemInfo> getBig_group_infosAsData()
/*     */     {
/* 474 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/*     */       
/* 476 */       GroupShoppingInfo _o_ = GroupShoppingInfo.this;
/* 477 */       Map<Integer, xbean.BigGroupShoppingItemInfo> big_group_infos = new HashMap();
/* 478 */       for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : _o_.big_group_infos.entrySet())
/* 479 */         big_group_infos.put(_e_.getKey(), new BigGroupShoppingItemInfo.Data((xbean.BigGroupShoppingItemInfo)_e_.getValue()));
/* 480 */       return big_group_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SmallGroupShoppingItemInfo> getSmall_group_infos()
/*     */     {
/* 487 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/* 488 */       return xdb.Consts.constMap(GroupShoppingInfo.this.small_group_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SmallGroupShoppingItemInfo> getSmall_group_infosAsData()
/*     */     {
/* 495 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/*     */       
/* 497 */       GroupShoppingInfo _o_ = GroupShoppingInfo.this;
/* 498 */       Map<Integer, xbean.SmallGroupShoppingItemInfo> small_group_infos = new HashMap();
/* 499 */       for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : _o_.small_group_infos.entrySet())
/* 500 */         small_group_infos.put(_e_.getKey(), new SmallGroupShoppingItemInfo.Data((xbean.SmallGroupShoppingItemInfo)_e_.getValue()));
/* 501 */       return small_group_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getIncompleted_small_groups()
/*     */     {
/* 508 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/* 509 */       return xdb.Consts.constSet(GroupShoppingInfo.this.incompleted_small_groups);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getIncompleted_small_groupsAsData()
/*     */     {
/* 515 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/*     */       
/* 517 */       GroupShoppingInfo _o_ = GroupShoppingInfo.this;
/* 518 */       Set<Long> incompleted_small_groups = new SetX();
/* 519 */       incompleted_small_groups.addAll(_o_.incompleted_small_groups);
/* 520 */       return incompleted_small_groups;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 526 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/* 527 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 533 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/* 534 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 540 */       return GroupShoppingInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 546 */       return GroupShoppingInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 552 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/* 553 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 559 */       return GroupShoppingInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 565 */       return GroupShoppingInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 571 */       GroupShoppingInfo.this._xdb_verify_unsafe_();
/* 572 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 578 */       return GroupShoppingInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 584 */       return GroupShoppingInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 590 */       return GroupShoppingInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 596 */       return GroupShoppingInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 602 */       return GroupShoppingInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 608 */       return GroupShoppingInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 614 */       return GroupShoppingInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GroupShoppingInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.BigGroupShoppingItemInfo> big_group_infos;
/*     */     
/*     */     private HashMap<Integer, xbean.SmallGroupShoppingItemInfo> small_group_infos;
/*     */     
/*     */     private HashSet<Long> incompleted_small_groups;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 630 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 635 */       this.big_group_infos = new HashMap();
/* 636 */       this.small_group_infos = new HashMap();
/* 637 */       this.incompleted_small_groups = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.GroupShoppingInfo _o1_)
/*     */     {
/* 642 */       if ((_o1_ instanceof GroupShoppingInfo)) { assign((GroupShoppingInfo)_o1_);
/* 643 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 644 */       } else if ((_o1_ instanceof GroupShoppingInfo.Const)) assign(((GroupShoppingInfo.Const)_o1_).nThis()); else {
/* 645 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GroupShoppingInfo _o_) {
/* 650 */       this.big_group_infos = new HashMap();
/* 651 */       for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : _o_.big_group_infos.entrySet())
/* 652 */         this.big_group_infos.put(_e_.getKey(), new BigGroupShoppingItemInfo.Data((xbean.BigGroupShoppingItemInfo)_e_.getValue()));
/* 653 */       this.small_group_infos = new HashMap();
/* 654 */       for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : _o_.small_group_infos.entrySet())
/* 655 */         this.small_group_infos.put(_e_.getKey(), new SmallGroupShoppingItemInfo.Data((xbean.SmallGroupShoppingItemInfo)_e_.getValue()));
/* 656 */       this.incompleted_small_groups = new HashSet();
/* 657 */       this.incompleted_small_groups.addAll(_o_.incompleted_small_groups);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 662 */       this.big_group_infos = new HashMap();
/* 663 */       for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : _o_.big_group_infos.entrySet())
/* 664 */         this.big_group_infos.put(_e_.getKey(), new BigGroupShoppingItemInfo.Data((xbean.BigGroupShoppingItemInfo)_e_.getValue()));
/* 665 */       this.small_group_infos = new HashMap();
/* 666 */       for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : _o_.small_group_infos.entrySet())
/* 667 */         this.small_group_infos.put(_e_.getKey(), new SmallGroupShoppingItemInfo.Data((xbean.SmallGroupShoppingItemInfo)_e_.getValue()));
/* 668 */       this.incompleted_small_groups = new HashSet();
/* 669 */       this.incompleted_small_groups.addAll(_o_.incompleted_small_groups);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 675 */       _os_.compact_uint32(this.big_group_infos.size());
/* 676 */       for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : this.big_group_infos.entrySet())
/*     */       {
/* 678 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 679 */         ((xbean.BigGroupShoppingItemInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 681 */       _os_.compact_uint32(this.small_group_infos.size());
/* 682 */       for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : this.small_group_infos.entrySet())
/*     */       {
/* 684 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 685 */         ((xbean.SmallGroupShoppingItemInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 687 */       _os_.compact_uint32(this.incompleted_small_groups.size());
/* 688 */       for (Long _v_ : this.incompleted_small_groups)
/*     */       {
/* 690 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 692 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 699 */       int size = _os_.uncompact_uint32();
/* 700 */       if (size >= 12)
/*     */       {
/* 702 */         this.big_group_infos = new HashMap(size * 2);
/*     */       }
/* 704 */       for (; size > 0; size--)
/*     */       {
/* 706 */         int _k_ = 0;
/* 707 */         _k_ = _os_.unmarshal_int();
/* 708 */         xbean.BigGroupShoppingItemInfo _v_ = xbean.Pod.newBigGroupShoppingItemInfoData();
/* 709 */         _v_.unmarshal(_os_);
/* 710 */         this.big_group_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 714 */       int size = _os_.uncompact_uint32();
/* 715 */       if (size >= 12)
/*     */       {
/* 717 */         this.small_group_infos = new HashMap(size * 2);
/*     */       }
/* 719 */       for (; size > 0; size--)
/*     */       {
/* 721 */         int _k_ = 0;
/* 722 */         _k_ = _os_.unmarshal_int();
/* 723 */         xbean.SmallGroupShoppingItemInfo _v_ = xbean.Pod.newSmallGroupShoppingItemInfoData();
/* 724 */         _v_.unmarshal(_os_);
/* 725 */         this.small_group_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 728 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 730 */         long _v_ = 0L;
/* 731 */         _v_ = _os_.unmarshal_long();
/* 732 */         this.incompleted_small_groups.add(Long.valueOf(_v_));
/*     */       }
/* 734 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 740 */       int _size_ = 0;
/* 741 */       for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : this.big_group_infos.entrySet())
/*     */       {
/* 743 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 744 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 746 */       for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : this.small_group_infos.entrySet())
/*     */       {
/* 748 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 749 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 751 */       for (Long _v_ : this.incompleted_small_groups)
/*     */       {
/* 753 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */       }
/* 755 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 763 */         for (Map.Entry<Integer, xbean.BigGroupShoppingItemInfo> _e_ : this.big_group_infos.entrySet())
/*     */         {
/* 765 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 766 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 768 */         for (Map.Entry<Integer, xbean.SmallGroupShoppingItemInfo> _e_ : this.small_group_infos.entrySet())
/*     */         {
/* 770 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 771 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 773 */         for (Long _v_ : this.incompleted_small_groups)
/*     */         {
/* 775 */           _output_.writeInt64(3, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 780 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 782 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 790 */         boolean done = false;
/* 791 */         while (!done)
/*     */         {
/* 793 */           int tag = _input_.readTag();
/* 794 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 798 */             done = true;
/* 799 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 803 */             int _k_ = 0;
/* 804 */             _k_ = _input_.readInt32();
/* 805 */             int readTag = _input_.readTag();
/* 806 */             if (10 != readTag)
/*     */             {
/* 808 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 810 */             xbean.BigGroupShoppingItemInfo _v_ = xbean.Pod.newBigGroupShoppingItemInfoData();
/* 811 */             _input_.readMessage(_v_);
/* 812 */             this.big_group_infos.put(Integer.valueOf(_k_), _v_);
/* 813 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 817 */             int _k_ = 0;
/* 818 */             _k_ = _input_.readInt32();
/* 819 */             int readTag = _input_.readTag();
/* 820 */             if (18 != readTag)
/*     */             {
/* 822 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 824 */             xbean.SmallGroupShoppingItemInfo _v_ = xbean.Pod.newSmallGroupShoppingItemInfoData();
/* 825 */             _input_.readMessage(_v_);
/* 826 */             this.small_group_infos.put(Integer.valueOf(_k_), _v_);
/* 827 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 831 */             long _v_ = 0L;
/* 832 */             _v_ = _input_.readInt64();
/* 833 */             this.incompleted_small_groups.add(Long.valueOf(_v_));
/* 834 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 838 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 840 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 849 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 853 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 855 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingInfo copy()
/*     */     {
/* 861 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingInfo toData()
/*     */     {
/* 867 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingInfo toBean()
/*     */     {
/* 872 */       return new GroupShoppingInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupShoppingInfo toDataIf()
/*     */     {
/* 878 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GroupShoppingInfo toBeanIf()
/*     */     {
/* 883 */       return new GroupShoppingInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 889 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 893 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 897 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 901 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 905 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 909 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 913 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BigGroupShoppingItemInfo> getBig_group_infos()
/*     */     {
/* 920 */       return this.big_group_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BigGroupShoppingItemInfo> getBig_group_infosAsData()
/*     */     {
/* 927 */       return this.big_group_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SmallGroupShoppingItemInfo> getSmall_group_infos()
/*     */     {
/* 934 */       return this.small_group_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SmallGroupShoppingItemInfo> getSmall_group_infosAsData()
/*     */     {
/* 941 */       return this.small_group_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getIncompleted_small_groups()
/*     */     {
/* 948 */       return this.incompleted_small_groups;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getIncompleted_small_groupsAsData()
/*     */     {
/* 955 */       return this.incompleted_small_groups;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 961 */       if (!(_o1_ instanceof Data)) return false;
/* 962 */       Data _o_ = (Data)_o1_;
/* 963 */       if (!this.big_group_infos.equals(_o_.big_group_infos)) return false;
/* 964 */       if (!this.small_group_infos.equals(_o_.small_group_infos)) return false;
/* 965 */       if (!this.incompleted_small_groups.equals(_o_.incompleted_small_groups)) return false;
/* 966 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 972 */       int _h_ = 0;
/* 973 */       _h_ += this.big_group_infos.hashCode();
/* 974 */       _h_ += this.small_group_infos.hashCode();
/* 975 */       _h_ += this.incompleted_small_groups.hashCode();
/* 976 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 982 */       StringBuilder _sb_ = new StringBuilder();
/* 983 */       _sb_.append("(");
/* 984 */       _sb_.append(this.big_group_infos);
/* 985 */       _sb_.append(",");
/* 986 */       _sb_.append(this.small_group_infos);
/* 987 */       _sb_.append(",");
/* 988 */       _sb_.append(this.incompleted_small_groups);
/* 989 */       _sb_.append(")");
/* 990 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GroupShoppingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */