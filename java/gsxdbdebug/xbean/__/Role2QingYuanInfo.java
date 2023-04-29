/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class Role2QingYuanInfo extends xdb.XBean implements xbean.Role2QingYuanInfo
/*     */ {
/*     */   private LinkedList<Long> qing_yuan_role_list;
/*     */   private HashMap<Long, xbean.QingYuanRoleInfo> qing_yuan_map_info;
/*     */   private SetX<Integer> aleardy_used_appellation_cfg_id_set;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.qing_yuan_role_list.clear();
/*  23 */     this.qing_yuan_map_info.clear();
/*  24 */     this.aleardy_used_appellation_cfg_id_set.clear();
/*     */   }
/*     */   
/*     */   Role2QingYuanInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.qing_yuan_role_list = new LinkedList();
/*  31 */     this.qing_yuan_map_info = new HashMap();
/*  32 */     this.aleardy_used_appellation_cfg_id_set = new SetX();
/*     */   }
/*     */   
/*     */   public Role2QingYuanInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2QingYuanInfo(Role2QingYuanInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2QingYuanInfo(xbean.Role2QingYuanInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof Role2QingYuanInfo)) { assign((Role2QingYuanInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Role2QingYuanInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.qing_yuan_role_list = new LinkedList();
/*  58 */     this.qing_yuan_role_list.addAll(_o_.qing_yuan_role_list);
/*  59 */     this.qing_yuan_map_info = new HashMap();
/*  60 */     for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : _o_.qing_yuan_map_info.entrySet())
/*  61 */       this.qing_yuan_map_info.put(_e_.getKey(), new QingYuanRoleInfo((xbean.QingYuanRoleInfo)_e_.getValue(), this, "qing_yuan_map_info"));
/*  62 */     this.aleardy_used_appellation_cfg_id_set = new SetX();
/*  63 */     this.aleardy_used_appellation_cfg_id_set.addAll(_o_.aleardy_used_appellation_cfg_id_set);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  68 */     this.qing_yuan_role_list = new LinkedList();
/*  69 */     this.qing_yuan_role_list.addAll(_o_.qing_yuan_role_list);
/*  70 */     this.qing_yuan_map_info = new HashMap();
/*  71 */     for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : _o_.qing_yuan_map_info.entrySet())
/*  72 */       this.qing_yuan_map_info.put(_e_.getKey(), new QingYuanRoleInfo((xbean.QingYuanRoleInfo)_e_.getValue(), this, "qing_yuan_map_info"));
/*  73 */     this.aleardy_used_appellation_cfg_id_set = new SetX();
/*  74 */     this.aleardy_used_appellation_cfg_id_set.addAll(_o_.aleardy_used_appellation_cfg_id_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.compact_uint32(this.qing_yuan_role_list.size());
/*  82 */     for (Long _v_ : this.qing_yuan_role_list)
/*     */     {
/*  84 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  86 */     _os_.compact_uint32(this.qing_yuan_map_info.size());
/*  87 */     for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : this.qing_yuan_map_info.entrySet())
/*     */     {
/*  89 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  90 */       ((xbean.QingYuanRoleInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  92 */     _os_.compact_uint32(this.aleardy_used_appellation_cfg_id_set.size());
/*  93 */     for (Integer _v_ : this.aleardy_used_appellation_cfg_id_set)
/*     */     {
/*  95 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 106 */       long _v_ = 0L;
/* 107 */       _v_ = _os_.unmarshal_long();
/* 108 */       this.qing_yuan_role_list.add(Long.valueOf(_v_));
/*     */     }
/*     */     
/* 111 */     int size = _os_.uncompact_uint32();
/* 112 */     if (size >= 12)
/*     */     {
/* 114 */       this.qing_yuan_map_info = new HashMap(size * 2);
/*     */     }
/* 116 */     for (; size > 0; size--)
/*     */     {
/* 118 */       long _k_ = 0L;
/* 119 */       _k_ = _os_.unmarshal_long();
/* 120 */       xbean.QingYuanRoleInfo _v_ = new QingYuanRoleInfo(0, this, "qing_yuan_map_info");
/* 121 */       _v_.unmarshal(_os_);
/* 122 */       this.qing_yuan_map_info.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 125 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 127 */       int _v_ = 0;
/* 128 */       _v_ = _os_.unmarshal_int();
/* 129 */       this.aleardy_used_appellation_cfg_id_set.add(Integer.valueOf(_v_));
/*     */     }
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     for (Long _v_ : this.qing_yuan_role_list)
/*     */     {
/* 141 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 143 */     for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : this.qing_yuan_map_info.entrySet())
/*     */     {
/* 145 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 146 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 148 */     for (Integer _v_ : this.aleardy_used_appellation_cfg_id_set)
/*     */     {
/* 150 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 152 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       for (Long _v_ : this.qing_yuan_role_list)
/*     */       {
/* 163 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 165 */       for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : this.qing_yuan_map_info.entrySet())
/*     */       {
/* 167 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 168 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 170 */       for (Integer _v_ : this.aleardy_used_appellation_cfg_id_set)
/*     */       {
/* 172 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 188 */       boolean done = false;
/* 189 */       while (!done)
/*     */       {
/* 191 */         int tag = _input_.readTag();
/* 192 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 196 */           done = true;
/* 197 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 201 */           long _v_ = 0L;
/* 202 */           _v_ = _input_.readInt64();
/* 203 */           this.qing_yuan_role_list.add(Long.valueOf(_v_));
/* 204 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 208 */           long _k_ = 0L;
/* 209 */           _k_ = _input_.readInt64();
/* 210 */           int readTag = _input_.readTag();
/* 211 */           if (18 != readTag)
/*     */           {
/* 213 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 215 */           xbean.QingYuanRoleInfo _v_ = new QingYuanRoleInfo(0, this, "qing_yuan_map_info");
/* 216 */           _input_.readMessage(_v_);
/* 217 */           this.qing_yuan_map_info.put(Long.valueOf(_k_), _v_);
/* 218 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 222 */           int _v_ = 0;
/* 223 */           _v_ = _input_.readInt32();
/* 224 */           this.aleardy_used_appellation_cfg_id_set.add(Integer.valueOf(_v_));
/* 225 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 229 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 231 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 240 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 244 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 246 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2QingYuanInfo copy()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new Role2QingYuanInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2QingYuanInfo toData()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2QingYuanInfo toBean()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return new Role2QingYuanInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2QingYuanInfo toDataIf()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2QingYuanInfo toBeanIf()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.List<Long> getQing_yuan_role_list()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     return xdb.Logs.logList(new xdb.LogKey(this, "qing_yuan_role_list"), this.qing_yuan_role_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<Long> getQing_yuan_role_listAsData()
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/*     */     
/* 302 */     Role2QingYuanInfo _o_ = this;
/* 303 */     java.util.List<Long> qing_yuan_role_list = new LinkedList();
/* 304 */     qing_yuan_role_list.addAll(_o_.qing_yuan_role_list);
/* 305 */     return qing_yuan_role_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, xbean.QingYuanRoleInfo> getQing_yuan_map_info()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     return xdb.Logs.logMap(new xdb.LogKey(this, "qing_yuan_map_info"), this.qing_yuan_map_info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Long, xbean.QingYuanRoleInfo> getQing_yuan_map_infoAsData()
/*     */   {
/* 320 */     _xdb_verify_unsafe_();
/*     */     
/* 322 */     Role2QingYuanInfo _o_ = this;
/* 323 */     java.util.Map<Long, xbean.QingYuanRoleInfo> qing_yuan_map_info = new HashMap();
/* 324 */     for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : _o_.qing_yuan_map_info.entrySet())
/* 325 */       qing_yuan_map_info.put(_e_.getKey(), new QingYuanRoleInfo.Data((xbean.QingYuanRoleInfo)_e_.getValue()));
/* 326 */     return qing_yuan_map_info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getAleardy_used_appellation_cfg_id_set()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     return xdb.Logs.logSet(new xdb.LogKey(this, "aleardy_used_appellation_cfg_id_set"), this.aleardy_used_appellation_cfg_id_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getAleardy_used_appellation_cfg_id_setAsData()
/*     */   {
/* 340 */     _xdb_verify_unsafe_();
/*     */     
/* 342 */     Role2QingYuanInfo _o_ = this;
/* 343 */     Set<Integer> aleardy_used_appellation_cfg_id_set = new SetX();
/* 344 */     aleardy_used_appellation_cfg_id_set.addAll(_o_.aleardy_used_appellation_cfg_id_set);
/* 345 */     return aleardy_used_appellation_cfg_id_set;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     Role2QingYuanInfo _o_ = null;
/* 353 */     if ((_o1_ instanceof Role2QingYuanInfo)) { _o_ = (Role2QingYuanInfo)_o1_;
/* 354 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 355 */       return false;
/* 356 */     if (!this.qing_yuan_role_list.equals(_o_.qing_yuan_role_list)) return false;
/* 357 */     if (!this.qing_yuan_map_info.equals(_o_.qing_yuan_map_info)) return false;
/* 358 */     if (!this.aleardy_used_appellation_cfg_id_set.equals(_o_.aleardy_used_appellation_cfg_id_set)) return false;
/* 359 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 365 */     _xdb_verify_unsafe_();
/* 366 */     int _h_ = 0;
/* 367 */     _h_ += this.qing_yuan_role_list.hashCode();
/* 368 */     _h_ += this.qing_yuan_map_info.hashCode();
/* 369 */     _h_ += this.aleardy_used_appellation_cfg_id_set.hashCode();
/* 370 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 376 */     _xdb_verify_unsafe_();
/* 377 */     StringBuilder _sb_ = new StringBuilder();
/* 378 */     _sb_.append("(");
/* 379 */     _sb_.append(this.qing_yuan_role_list);
/* 380 */     _sb_.append(",");
/* 381 */     _sb_.append(this.qing_yuan_map_info);
/* 382 */     _sb_.append(",");
/* 383 */     _sb_.append(this.aleardy_used_appellation_cfg_id_set);
/* 384 */     _sb_.append(")");
/* 385 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 391 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 392 */     lb.add(new xdb.logs.ListenableChanged().setVarName("qing_yuan_role_list"));
/* 393 */     lb.add(new xdb.logs.ListenableMap().setVarName("qing_yuan_map_info"));
/* 394 */     lb.add(new xdb.logs.ListenableSet().setVarName("aleardy_used_appellation_cfg_id_set"));
/* 395 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2QingYuanInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2QingYuanInfo nThis() {
/* 402 */       return Role2QingYuanInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 408 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2QingYuanInfo copy()
/*     */     {
/* 414 */       return Role2QingYuanInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2QingYuanInfo toData()
/*     */     {
/* 420 */       return Role2QingYuanInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2QingYuanInfo toBean()
/*     */     {
/* 425 */       return Role2QingYuanInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2QingYuanInfo toDataIf()
/*     */     {
/* 431 */       return Role2QingYuanInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2QingYuanInfo toBeanIf()
/*     */     {
/* 436 */       return Role2QingYuanInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<Long> getQing_yuan_role_list()
/*     */     {
/* 443 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/* 444 */       return xdb.Consts.constList(Role2QingYuanInfo.this.qing_yuan_role_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public java.util.List<Long> getQing_yuan_role_listAsData()
/*     */     {
/* 450 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/*     */       
/* 452 */       Role2QingYuanInfo _o_ = Role2QingYuanInfo.this;
/* 453 */       java.util.List<Long> qing_yuan_role_list = new LinkedList();
/* 454 */       qing_yuan_role_list.addAll(_o_.qing_yuan_role_list);
/* 455 */       return qing_yuan_role_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, xbean.QingYuanRoleInfo> getQing_yuan_map_info()
/*     */     {
/* 462 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/* 463 */       return xdb.Consts.constMap(Role2QingYuanInfo.this.qing_yuan_map_info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, xbean.QingYuanRoleInfo> getQing_yuan_map_infoAsData()
/*     */     {
/* 470 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/*     */       
/* 472 */       Role2QingYuanInfo _o_ = Role2QingYuanInfo.this;
/* 473 */       java.util.Map<Long, xbean.QingYuanRoleInfo> qing_yuan_map_info = new HashMap();
/* 474 */       for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : _o_.qing_yuan_map_info.entrySet())
/* 475 */         qing_yuan_map_info.put(_e_.getKey(), new QingYuanRoleInfo.Data((xbean.QingYuanRoleInfo)_e_.getValue()));
/* 476 */       return qing_yuan_map_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getAleardy_used_appellation_cfg_id_set()
/*     */     {
/* 483 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/* 484 */       return xdb.Consts.constSet(Role2QingYuanInfo.this.aleardy_used_appellation_cfg_id_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getAleardy_used_appellation_cfg_id_setAsData()
/*     */     {
/* 490 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/*     */       
/* 492 */       Role2QingYuanInfo _o_ = Role2QingYuanInfo.this;
/* 493 */       Set<Integer> aleardy_used_appellation_cfg_id_set = new SetX();
/* 494 */       aleardy_used_appellation_cfg_id_set.addAll(_o_.aleardy_used_appellation_cfg_id_set);
/* 495 */       return aleardy_used_appellation_cfg_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 501 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return Role2QingYuanInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return Role2QingYuanInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return Role2QingYuanInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return Role2QingYuanInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       Role2QingYuanInfo.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 553 */       return Role2QingYuanInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return Role2QingYuanInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return Role2QingYuanInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return Role2QingYuanInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return Role2QingYuanInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return Role2QingYuanInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return Role2QingYuanInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2QingYuanInfo
/*     */   {
/*     */     private LinkedList<Long> qing_yuan_role_list;
/*     */     
/*     */     private HashMap<Long, xbean.QingYuanRoleInfo> qing_yuan_map_info;
/*     */     
/*     */     private HashSet<Integer> aleardy_used_appellation_cfg_id_set;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 605 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 610 */       this.qing_yuan_role_list = new LinkedList();
/* 611 */       this.qing_yuan_map_info = new HashMap();
/* 612 */       this.aleardy_used_appellation_cfg_id_set = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.Role2QingYuanInfo _o1_)
/*     */     {
/* 617 */       if ((_o1_ instanceof Role2QingYuanInfo)) { assign((Role2QingYuanInfo)_o1_);
/* 618 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 619 */       } else if ((_o1_ instanceof Role2QingYuanInfo.Const)) assign(((Role2QingYuanInfo.Const)_o1_).nThis()); else {
/* 620 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Role2QingYuanInfo _o_) {
/* 625 */       this.qing_yuan_role_list = new LinkedList();
/* 626 */       this.qing_yuan_role_list.addAll(_o_.qing_yuan_role_list);
/* 627 */       this.qing_yuan_map_info = new HashMap();
/* 628 */       for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : _o_.qing_yuan_map_info.entrySet())
/* 629 */         this.qing_yuan_map_info.put(_e_.getKey(), new QingYuanRoleInfo.Data((xbean.QingYuanRoleInfo)_e_.getValue()));
/* 630 */       this.aleardy_used_appellation_cfg_id_set = new HashSet();
/* 631 */       this.aleardy_used_appellation_cfg_id_set.addAll(_o_.aleardy_used_appellation_cfg_id_set);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 636 */       this.qing_yuan_role_list = new LinkedList();
/* 637 */       this.qing_yuan_role_list.addAll(_o_.qing_yuan_role_list);
/* 638 */       this.qing_yuan_map_info = new HashMap();
/* 639 */       for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : _o_.qing_yuan_map_info.entrySet())
/* 640 */         this.qing_yuan_map_info.put(_e_.getKey(), new QingYuanRoleInfo.Data((xbean.QingYuanRoleInfo)_e_.getValue()));
/* 641 */       this.aleardy_used_appellation_cfg_id_set = new HashSet();
/* 642 */       this.aleardy_used_appellation_cfg_id_set.addAll(_o_.aleardy_used_appellation_cfg_id_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 648 */       _os_.compact_uint32(this.qing_yuan_role_list.size());
/* 649 */       for (Long _v_ : this.qing_yuan_role_list)
/*     */       {
/* 651 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 653 */       _os_.compact_uint32(this.qing_yuan_map_info.size());
/* 654 */       for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : this.qing_yuan_map_info.entrySet())
/*     */       {
/* 656 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 657 */         ((xbean.QingYuanRoleInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 659 */       _os_.compact_uint32(this.aleardy_used_appellation_cfg_id_set.size());
/* 660 */       for (Integer _v_ : this.aleardy_used_appellation_cfg_id_set)
/*     */       {
/* 662 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 664 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 670 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 672 */         long _v_ = 0L;
/* 673 */         _v_ = _os_.unmarshal_long();
/* 674 */         this.qing_yuan_role_list.add(Long.valueOf(_v_));
/*     */       }
/*     */       
/* 677 */       int size = _os_.uncompact_uint32();
/* 678 */       if (size >= 12)
/*     */       {
/* 680 */         this.qing_yuan_map_info = new HashMap(size * 2);
/*     */       }
/* 682 */       for (; size > 0; size--)
/*     */       {
/* 684 */         long _k_ = 0L;
/* 685 */         _k_ = _os_.unmarshal_long();
/* 686 */         xbean.QingYuanRoleInfo _v_ = xbean.Pod.newQingYuanRoleInfoData();
/* 687 */         _v_.unmarshal(_os_);
/* 688 */         this.qing_yuan_map_info.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 691 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 693 */         int _v_ = 0;
/* 694 */         _v_ = _os_.unmarshal_int();
/* 695 */         this.aleardy_used_appellation_cfg_id_set.add(Integer.valueOf(_v_));
/*     */       }
/* 697 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 703 */       int _size_ = 0;
/* 704 */       for (Long _v_ : this.qing_yuan_role_list)
/*     */       {
/* 706 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 708 */       for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : this.qing_yuan_map_info.entrySet())
/*     */       {
/* 710 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 711 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 713 */       for (Integer _v_ : this.aleardy_used_appellation_cfg_id_set)
/*     */       {
/* 715 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 717 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 725 */         for (Long _v_ : this.qing_yuan_role_list)
/*     */         {
/* 727 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 729 */         for (Map.Entry<Long, xbean.QingYuanRoleInfo> _e_ : this.qing_yuan_map_info.entrySet())
/*     */         {
/* 731 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 732 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 734 */         for (Integer _v_ : this.aleardy_used_appellation_cfg_id_set)
/*     */         {
/* 736 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 751 */         boolean done = false;
/* 752 */         while (!done)
/*     */         {
/* 754 */           int tag = _input_.readTag();
/* 755 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 759 */             done = true;
/* 760 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 764 */             long _v_ = 0L;
/* 765 */             _v_ = _input_.readInt64();
/* 766 */             this.qing_yuan_role_list.add(Long.valueOf(_v_));
/* 767 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 771 */             long _k_ = 0L;
/* 772 */             _k_ = _input_.readInt64();
/* 773 */             int readTag = _input_.readTag();
/* 774 */             if (18 != readTag)
/*     */             {
/* 776 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 778 */             xbean.QingYuanRoleInfo _v_ = xbean.Pod.newQingYuanRoleInfoData();
/* 779 */             _input_.readMessage(_v_);
/* 780 */             this.qing_yuan_map_info.put(Long.valueOf(_k_), _v_);
/* 781 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 785 */             int _v_ = 0;
/* 786 */             _v_ = _input_.readInt32();
/* 787 */             this.aleardy_used_appellation_cfg_id_set.add(Integer.valueOf(_v_));
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
/*     */       catch (java.io.IOException e)
/*     */       {
/* 807 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 809 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2QingYuanInfo copy()
/*     */     {
/* 815 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2QingYuanInfo toData()
/*     */     {
/* 821 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2QingYuanInfo toBean()
/*     */     {
/* 826 */       return new Role2QingYuanInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2QingYuanInfo toDataIf()
/*     */     {
/* 832 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2QingYuanInfo toBeanIf()
/*     */     {
/* 837 */       return new Role2QingYuanInfo(this, null, null);
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
/*     */     public java.util.List<Long> getQing_yuan_role_list()
/*     */     {
/* 874 */       return this.qing_yuan_role_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<Long> getQing_yuan_role_listAsData()
/*     */     {
/* 881 */       return this.qing_yuan_role_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, xbean.QingYuanRoleInfo> getQing_yuan_map_info()
/*     */     {
/* 888 */       return this.qing_yuan_map_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Long, xbean.QingYuanRoleInfo> getQing_yuan_map_infoAsData()
/*     */     {
/* 895 */       return this.qing_yuan_map_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getAleardy_used_appellation_cfg_id_set()
/*     */     {
/* 902 */       return this.aleardy_used_appellation_cfg_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getAleardy_used_appellation_cfg_id_setAsData()
/*     */     {
/* 909 */       return this.aleardy_used_appellation_cfg_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 915 */       if (!(_o1_ instanceof Data)) return false;
/* 916 */       Data _o_ = (Data)_o1_;
/* 917 */       if (!this.qing_yuan_role_list.equals(_o_.qing_yuan_role_list)) return false;
/* 918 */       if (!this.qing_yuan_map_info.equals(_o_.qing_yuan_map_info)) return false;
/* 919 */       if (!this.aleardy_used_appellation_cfg_id_set.equals(_o_.aleardy_used_appellation_cfg_id_set)) return false;
/* 920 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 926 */       int _h_ = 0;
/* 927 */       _h_ += this.qing_yuan_role_list.hashCode();
/* 928 */       _h_ += this.qing_yuan_map_info.hashCode();
/* 929 */       _h_ += this.aleardy_used_appellation_cfg_id_set.hashCode();
/* 930 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 936 */       StringBuilder _sb_ = new StringBuilder();
/* 937 */       _sb_.append("(");
/* 938 */       _sb_.append(this.qing_yuan_role_list);
/* 939 */       _sb_.append(",");
/* 940 */       _sb_.append(this.qing_yuan_map_info);
/* 941 */       _sb_.append(",");
/* 942 */       _sb_.append(this.aleardy_used_appellation_cfg_id_set);
/* 943 */       _sb_.append(")");
/* 944 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2QingYuanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */