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
/*     */ public final class TransferOccupationPropertiesSys extends XBean implements xbean.TransferOccupationPropertiesSys
/*     */ {
/*     */   private HashMap<Integer, xbean.BasicPropertiesSystem> property_sys_map;
/*     */   private int activity_bp_sys;
/*     */   private int today_prop_sys_switch_count;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.property_sys_map.clear();
/*  23 */     this.activity_bp_sys = 0;
/*  24 */     this.today_prop_sys_switch_count = 0;
/*     */   }
/*     */   
/*     */   TransferOccupationPropertiesSys(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.property_sys_map = new HashMap();
/*     */   }
/*     */   
/*     */   public TransferOccupationPropertiesSys()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TransferOccupationPropertiesSys(TransferOccupationPropertiesSys _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TransferOccupationPropertiesSys(xbean.TransferOccupationPropertiesSys _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof TransferOccupationPropertiesSys)) { assign((TransferOccupationPropertiesSys)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(TransferOccupationPropertiesSys _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.property_sys_map = new HashMap();
/*  56 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.property_sys_map.entrySet())
/*  57 */       this.property_sys_map.put(_e_.getKey(), new BasicPropertiesSystem((xbean.BasicPropertiesSystem)_e_.getValue(), this, "property_sys_map"));
/*  58 */     this.activity_bp_sys = _o_.activity_bp_sys;
/*  59 */     this.today_prop_sys_switch_count = _o_.today_prop_sys_switch_count;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.property_sys_map = new HashMap();
/*  65 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.property_sys_map.entrySet())
/*  66 */       this.property_sys_map.put(_e_.getKey(), new BasicPropertiesSystem((xbean.BasicPropertiesSystem)_e_.getValue(), this, "property_sys_map"));
/*  67 */     this.activity_bp_sys = _o_.activity_bp_sys;
/*  68 */     this.today_prop_sys_switch_count = _o_.today_prop_sys_switch_count;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.property_sys_map.size());
/*  76 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.property_sys_map.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       ((xbean.BasicPropertiesSystem)_e_.getValue()).marshal(_os_);
/*     */     }
/*  81 */     _os_.marshal(this.activity_bp_sys);
/*  82 */     _os_.marshal(this.today_prop_sys_switch_count);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*     */     
/*  91 */     int size = _os_.uncompact_uint32();
/*  92 */     if (size >= 12)
/*     */     {
/*  94 */       this.property_sys_map = new HashMap(size * 2);
/*     */     }
/*  96 */     for (; size > 0; size--)
/*     */     {
/*  98 */       int _k_ = 0;
/*  99 */       _k_ = _os_.unmarshal_int();
/* 100 */       xbean.BasicPropertiesSystem _v_ = new BasicPropertiesSystem(0, this, "property_sys_map");
/* 101 */       _v_.unmarshal(_os_);
/* 102 */       this.property_sys_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 105 */     this.activity_bp_sys = _os_.unmarshal_int();
/* 106 */     this.today_prop_sys_switch_count = _os_.unmarshal_int();
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.property_sys_map.entrySet())
/*     */     {
/* 117 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 118 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 120 */     _size_ += CodedOutputStream.computeInt32Size(2, this.activity_bp_sys);
/* 121 */     _size_ += CodedOutputStream.computeInt32Size(3, this.today_prop_sys_switch_count);
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.property_sys_map.entrySet())
/*     */       {
/* 133 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 134 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 136 */       _output_.writeInt32(2, this.activity_bp_sys);
/* 137 */       _output_.writeInt32(3, this.today_prop_sys_switch_count);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 143 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 152 */       boolean done = false;
/* 153 */       while (!done)
/*     */       {
/* 155 */         int tag = _input_.readTag();
/* 156 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 160 */           done = true;
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 165 */           int _k_ = 0;
/* 166 */           _k_ = _input_.readInt32();
/* 167 */           int readTag = _input_.readTag();
/* 168 */           if (10 != readTag)
/*     */           {
/* 170 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 172 */           xbean.BasicPropertiesSystem _v_ = new BasicPropertiesSystem(0, this, "property_sys_map");
/* 173 */           _input_.readMessage(_v_);
/* 174 */           this.property_sys_map.put(Integer.valueOf(_k_), _v_);
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 179 */           this.activity_bp_sys = _input_.readInt32();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 184 */           this.today_prop_sys_switch_count = _input_.readInt32();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationPropertiesSys copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new TransferOccupationPropertiesSys(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationPropertiesSys toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TransferOccupationPropertiesSys toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new TransferOccupationPropertiesSys(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationPropertiesSys toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TransferOccupationPropertiesSys toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.BasicPropertiesSystem> getProperty_sys_map()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return xdb.Logs.logMap(new LogKey(this, "property_sys_map"), this.property_sys_map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.BasicPropertiesSystem> getProperty_sys_mapAsData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/*     */     
/* 263 */     TransferOccupationPropertiesSys _o_ = this;
/* 264 */     Map<Integer, xbean.BasicPropertiesSystem> property_sys_map = new HashMap();
/* 265 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.property_sys_map.entrySet())
/* 266 */       property_sys_map.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/* 267 */     return property_sys_map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getActivity_bp_sys()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return this.activity_bp_sys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getToday_prop_sys_switch_count()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     return this.today_prop_sys_switch_count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActivity_bp_sys(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "activity_bp_sys")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogInt(this, TransferOccupationPropertiesSys.this.activity_bp_sys)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             TransferOccupationPropertiesSys.this.activity_bp_sys = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.activity_bp_sys = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToday_prop_sys_switch_count(int _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "today_prop_sys_switch_count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogInt(this, TransferOccupationPropertiesSys.this.today_prop_sys_switch_count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             TransferOccupationPropertiesSys.this.today_prop_sys_switch_count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.today_prop_sys_switch_count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     TransferOccupationPropertiesSys _o_ = null;
/* 333 */     if ((_o1_ instanceof TransferOccupationPropertiesSys)) { _o_ = (TransferOccupationPropertiesSys)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (!this.property_sys_map.equals(_o_.property_sys_map)) return false;
/* 337 */     if (this.activity_bp_sys != _o_.activity_bp_sys) return false;
/* 338 */     if (this.today_prop_sys_switch_count != _o_.today_prop_sys_switch_count) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ += this.property_sys_map.hashCode();
/* 348 */     _h_ += this.activity_bp_sys;
/* 349 */     _h_ += this.today_prop_sys_switch_count;
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this.property_sys_map);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this.activity_bp_sys);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.today_prop_sys_switch_count);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableMap().setVarName("property_sys_map"));
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("activity_bp_sys"));
/* 374 */     lb.add(new xdb.logs.ListenableChanged().setVarName("today_prop_sys_switch_count"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TransferOccupationPropertiesSys {
/*     */     private Const() {}
/*     */     
/*     */     TransferOccupationPropertiesSys nThis() {
/* 382 */       return TransferOccupationPropertiesSys.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationPropertiesSys copy()
/*     */     {
/* 394 */       return TransferOccupationPropertiesSys.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationPropertiesSys toData()
/*     */     {
/* 400 */       return TransferOccupationPropertiesSys.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationPropertiesSys toBean()
/*     */     {
/* 405 */       return TransferOccupationPropertiesSys.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationPropertiesSys toDataIf()
/*     */     {
/* 411 */       return TransferOccupationPropertiesSys.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationPropertiesSys toBeanIf()
/*     */     {
/* 416 */       return TransferOccupationPropertiesSys.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BasicPropertiesSystem> getProperty_sys_map()
/*     */     {
/* 423 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 424 */       return xdb.Consts.constMap(TransferOccupationPropertiesSys.this.property_sys_map);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BasicPropertiesSystem> getProperty_sys_mapAsData()
/*     */     {
/* 431 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/*     */       
/* 433 */       TransferOccupationPropertiesSys _o_ = TransferOccupationPropertiesSys.this;
/* 434 */       Map<Integer, xbean.BasicPropertiesSystem> property_sys_map = new HashMap();
/* 435 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.property_sys_map.entrySet())
/* 436 */         property_sys_map.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/* 437 */       return property_sys_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getActivity_bp_sys()
/*     */     {
/* 444 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 445 */       return TransferOccupationPropertiesSys.this.activity_bp_sys;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getToday_prop_sys_switch_count()
/*     */     {
/* 452 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 453 */       return TransferOccupationPropertiesSys.this.today_prop_sys_switch_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActivity_bp_sys(int _v_)
/*     */     {
/* 460 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_prop_sys_switch_count(int _v_)
/*     */     {
/* 468 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return TransferOccupationPropertiesSys.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return TransferOccupationPropertiesSys.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return TransferOccupationPropertiesSys.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return TransferOccupationPropertiesSys.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       TransferOccupationPropertiesSys.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return TransferOccupationPropertiesSys.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return TransferOccupationPropertiesSys.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return TransferOccupationPropertiesSys.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return TransferOccupationPropertiesSys.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return TransferOccupationPropertiesSys.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return TransferOccupationPropertiesSys.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return TransferOccupationPropertiesSys.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TransferOccupationPropertiesSys
/*     */   {
/*     */     private HashMap<Integer, xbean.BasicPropertiesSystem> property_sys_map;
/*     */     
/*     */     private int activity_bp_sys;
/*     */     
/*     */     private int today_prop_sys_switch_count;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.property_sys_map = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.TransferOccupationPropertiesSys _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof TransferOccupationPropertiesSys)) { assign((TransferOccupationPropertiesSys)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof TransferOccupationPropertiesSys.Const)) assign(((TransferOccupationPropertiesSys.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(TransferOccupationPropertiesSys _o_) {
/* 597 */       this.property_sys_map = new HashMap();
/* 598 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.property_sys_map.entrySet())
/* 599 */         this.property_sys_map.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/* 600 */       this.activity_bp_sys = _o_.activity_bp_sys;
/* 601 */       this.today_prop_sys_switch_count = _o_.today_prop_sys_switch_count;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 606 */       this.property_sys_map = new HashMap();
/* 607 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.property_sys_map.entrySet())
/* 608 */         this.property_sys_map.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/* 609 */       this.activity_bp_sys = _o_.activity_bp_sys;
/* 610 */       this.today_prop_sys_switch_count = _o_.today_prop_sys_switch_count;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.compact_uint32(this.property_sys_map.size());
/* 617 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.property_sys_map.entrySet())
/*     */       {
/* 619 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 620 */         ((xbean.BasicPropertiesSystem)_e_.getValue()).marshal(_os_);
/*     */       }
/* 622 */       _os_.marshal(this.activity_bp_sys);
/* 623 */       _os_.marshal(this.today_prop_sys_switch_count);
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 631 */       int size = _os_.uncompact_uint32();
/* 632 */       if (size >= 12)
/*     */       {
/* 634 */         this.property_sys_map = new HashMap(size * 2);
/*     */       }
/* 636 */       for (; size > 0; size--)
/*     */       {
/* 638 */         int _k_ = 0;
/* 639 */         _k_ = _os_.unmarshal_int();
/* 640 */         xbean.BasicPropertiesSystem _v_ = xbean.Pod.newBasicPropertiesSystemData();
/* 641 */         _v_.unmarshal(_os_);
/* 642 */         this.property_sys_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 645 */       this.activity_bp_sys = _os_.unmarshal_int();
/* 646 */       this.today_prop_sys_switch_count = _os_.unmarshal_int();
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.property_sys_map.entrySet())
/*     */       {
/* 656 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 657 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 659 */       _size_ += CodedOutputStream.computeInt32Size(2, this.activity_bp_sys);
/* 660 */       _size_ += CodedOutputStream.computeInt32Size(3, this.today_prop_sys_switch_count);
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.property_sys_map.entrySet())
/*     */         {
/* 671 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 672 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 674 */         _output_.writeInt32(2, this.activity_bp_sys);
/* 675 */         _output_.writeInt32(3, this.today_prop_sys_switch_count);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             int _k_ = 0;
/* 703 */             _k_ = _input_.readInt32();
/* 704 */             int readTag = _input_.readTag();
/* 705 */             if (10 != readTag)
/*     */             {
/* 707 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 709 */             xbean.BasicPropertiesSystem _v_ = xbean.Pod.newBasicPropertiesSystemData();
/* 710 */             _input_.readMessage(_v_);
/* 711 */             this.property_sys_map.put(Integer.valueOf(_k_), _v_);
/* 712 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 716 */             this.activity_bp_sys = _input_.readInt32();
/* 717 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 721 */             this.today_prop_sys_switch_count = _input_.readInt32();
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationPropertiesSys copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationPropertiesSys toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationPropertiesSys toBean()
/*     */     {
/* 760 */       return new TransferOccupationPropertiesSys(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationPropertiesSys toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationPropertiesSys toBeanIf()
/*     */     {
/* 771 */       return new TransferOccupationPropertiesSys(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BasicPropertiesSystem> getProperty_sys_map()
/*     */     {
/* 808 */       return this.property_sys_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.BasicPropertiesSystem> getProperty_sys_mapAsData()
/*     */     {
/* 815 */       return this.property_sys_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getActivity_bp_sys()
/*     */     {
/* 822 */       return this.activity_bp_sys;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getToday_prop_sys_switch_count()
/*     */     {
/* 829 */       return this.today_prop_sys_switch_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActivity_bp_sys(int _v_)
/*     */     {
/* 836 */       this.activity_bp_sys = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToday_prop_sys_switch_count(int _v_)
/*     */     {
/* 843 */       this.today_prop_sys_switch_count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (!this.property_sys_map.equals(_o_.property_sys_map)) return false;
/* 852 */       if (this.activity_bp_sys != _o_.activity_bp_sys) return false;
/* 853 */       if (this.today_prop_sys_switch_count != _o_.today_prop_sys_switch_count) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ += this.property_sys_map.hashCode();
/* 862 */       _h_ += this.activity_bp_sys;
/* 863 */       _h_ += this.today_prop_sys_switch_count;
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this.property_sys_map);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this.activity_bp_sys);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.today_prop_sys_switch_count);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TransferOccupationPropertiesSys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */