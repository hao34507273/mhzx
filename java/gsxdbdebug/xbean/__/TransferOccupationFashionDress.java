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
/*     */ public final class TransferOccupationFashionDress extends xdb.XBean implements xbean.TransferOccupationFashionDress
/*     */ {
/*     */   private int current_fashion_dress_cfg_id;
/*     */   private HashMap<Integer, xbean.FashionDressInfo> fashion_dress_map;
/*     */   private SetX<Integer> activate_property_set;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.current_fashion_dress_cfg_id = 0;
/*  23 */     this.fashion_dress_map.clear();
/*  24 */     this.activate_property_set.clear();
/*     */   }
/*     */   
/*     */   TransferOccupationFashionDress(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.fashion_dress_map = new HashMap();
/*  31 */     this.activate_property_set = new SetX();
/*     */   }
/*     */   
/*     */   public TransferOccupationFashionDress()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TransferOccupationFashionDress(TransferOccupationFashionDress _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TransferOccupationFashionDress(xbean.TransferOccupationFashionDress _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof TransferOccupationFashionDress)) { assign((TransferOccupationFashionDress)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(TransferOccupationFashionDress _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/*  57 */     this.fashion_dress_map = new HashMap();
/*  58 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*  59 */       this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo((xbean.FashionDressInfo)_e_.getValue(), this, "fashion_dress_map"));
/*  60 */     this.activate_property_set = new SetX();
/*  61 */     this.activate_property_set.addAll(_o_.activate_property_set);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/*  67 */     this.fashion_dress_map = new HashMap();
/*  68 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*  69 */       this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo((xbean.FashionDressInfo)_e_.getValue(), this, "fashion_dress_map"));
/*  70 */     this.activate_property_set = new SetX();
/*  71 */     this.activate_property_set.addAll(_o_.activate_property_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.marshal(this.current_fashion_dress_cfg_id);
/*  79 */     _os_.compact_uint32(this.fashion_dress_map.size());
/*  80 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*     */     {
/*  82 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  83 */       ((xbean.FashionDressInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  85 */     _os_.compact_uint32(this.activate_property_set.size());
/*  86 */     for (Integer _v_ : this.activate_property_set)
/*     */     {
/*  88 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     this.current_fashion_dress_cfg_id = _os_.unmarshal_int();
/*     */     
/*  99 */     int size = _os_.uncompact_uint32();
/* 100 */     if (size >= 12)
/*     */     {
/* 102 */       this.fashion_dress_map = new HashMap(size * 2);
/*     */     }
/* 104 */     for (; size > 0; size--)
/*     */     {
/* 106 */       int _k_ = 0;
/* 107 */       _k_ = _os_.unmarshal_int();
/* 108 */       xbean.FashionDressInfo _v_ = new FashionDressInfo(0, this, "fashion_dress_map");
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 113 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 115 */       int _v_ = 0;
/* 116 */       _v_ = _os_.unmarshal_int();
/* 117 */       this.activate_property_set.add(Integer.valueOf(_v_));
/*     */     }
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     int _size_ = 0;
/* 127 */     _size_ += CodedOutputStream.computeInt32Size(1, this.current_fashion_dress_cfg_id);
/* 128 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*     */     {
/* 130 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 131 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 133 */     for (Integer _v_ : this.activate_property_set)
/*     */     {
/* 135 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 137 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 143 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 146 */       _output_.writeInt32(1, this.current_fashion_dress_cfg_id);
/* 147 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*     */       {
/* 149 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 150 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 152 */       for (Integer _v_ : this.activate_property_set)
/*     */       {
/* 154 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 159 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 161 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 167 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 170 */       boolean done = false;
/* 171 */       while (!done)
/*     */       {
/* 173 */         int tag = _input_.readTag();
/* 174 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 178 */           done = true;
/* 179 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 183 */           this.current_fashion_dress_cfg_id = _input_.readInt32();
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 188 */           int _k_ = 0;
/* 189 */           _k_ = _input_.readInt32();
/* 190 */           int readTag = _input_.readTag();
/* 191 */           if (18 != readTag)
/*     */           {
/* 193 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 195 */           xbean.FashionDressInfo _v_ = new FashionDressInfo(0, this, "fashion_dress_map");
/* 196 */           _input_.readMessage(_v_);
/* 197 */           this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 202 */           int _v_ = 0;
/* 203 */           _v_ = _input_.readInt32();
/* 204 */           this.activate_property_set.add(Integer.valueOf(_v_));
/* 205 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 209 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 211 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 220 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 224 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 226 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationFashionDress copy()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new TransferOccupationFashionDress(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationFashionDress toData()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TransferOccupationFashionDress toBean()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new TransferOccupationFashionDress(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationFashionDress toDataIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TransferOccupationFashionDress toBeanIf()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurrent_fashion_dress_cfg_id()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return this.current_fashion_dress_cfg_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.FashionDressInfo> getFashion_dress_map()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     return xdb.Logs.logMap(new xdb.LogKey(this, "fashion_dress_map"), this.fashion_dress_map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.FashionDressInfo> getFashion_dress_mapAsData()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/*     */     
/* 291 */     TransferOccupationFashionDress _o_ = this;
/* 292 */     Map<Integer, xbean.FashionDressInfo> fashion_dress_map = new HashMap();
/* 293 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/* 294 */       fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/* 295 */     return fashion_dress_map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getActivate_property_set()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     return xdb.Logs.logSet(new xdb.LogKey(this, "activate_property_set"), this.activate_property_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getActivate_property_setAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     TransferOccupationFashionDress _o_ = this;
/* 312 */     Set<Integer> activate_property_set = new SetX();
/* 313 */     activate_property_set.addAll(_o_.activate_property_set);
/* 314 */     return activate_property_set;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurrent_fashion_dress_cfg_id(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new xdb.LogKey(this, "current_fashion_dress_cfg_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, TransferOccupationFashionDress.this.current_fashion_dress_cfg_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             TransferOccupationFashionDress.this.current_fashion_dress_cfg_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.current_fashion_dress_cfg_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     TransferOccupationFashionDress _o_ = null;
/* 343 */     if ((_o1_ instanceof TransferOccupationFashionDress)) { _o_ = (TransferOccupationFashionDress)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.current_fashion_dress_cfg_id != _o_.current_fashion_dress_cfg_id) return false;
/* 347 */     if (!this.fashion_dress_map.equals(_o_.fashion_dress_map)) return false;
/* 348 */     if (!this.activate_property_set.equals(_o_.activate_property_set)) return false;
/* 349 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 355 */     _xdb_verify_unsafe_();
/* 356 */     int _h_ = 0;
/* 357 */     _h_ += this.current_fashion_dress_cfg_id;
/* 358 */     _h_ += this.fashion_dress_map.hashCode();
/* 359 */     _h_ += this.activate_property_set.hashCode();
/* 360 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     StringBuilder _sb_ = new StringBuilder();
/* 368 */     _sb_.append("(");
/* 369 */     _sb_.append(this.current_fashion_dress_cfg_id);
/* 370 */     _sb_.append(",");
/* 371 */     _sb_.append(this.fashion_dress_map);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.activate_property_set);
/* 374 */     _sb_.append(")");
/* 375 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 381 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 382 */     lb.add(new xdb.logs.ListenableChanged().setVarName("current_fashion_dress_cfg_id"));
/* 383 */     lb.add(new xdb.logs.ListenableMap().setVarName("fashion_dress_map"));
/* 384 */     lb.add(new xdb.logs.ListenableSet().setVarName("activate_property_set"));
/* 385 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TransferOccupationFashionDress {
/*     */     private Const() {}
/*     */     
/*     */     TransferOccupationFashionDress nThis() {
/* 392 */       return TransferOccupationFashionDress.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 398 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationFashionDress copy()
/*     */     {
/* 404 */       return TransferOccupationFashionDress.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationFashionDress toData()
/*     */     {
/* 410 */       return TransferOccupationFashionDress.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationFashionDress toBean()
/*     */     {
/* 415 */       return TransferOccupationFashionDress.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationFashionDress toDataIf()
/*     */     {
/* 421 */       return TransferOccupationFashionDress.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationFashionDress toBeanIf()
/*     */     {
/* 426 */       return TransferOccupationFashionDress.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurrent_fashion_dress_cfg_id()
/*     */     {
/* 433 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 434 */       return TransferOccupationFashionDress.this.current_fashion_dress_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_map()
/*     */     {
/* 441 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 442 */       return xdb.Consts.constMap(TransferOccupationFashionDress.this.fashion_dress_map);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_mapAsData()
/*     */     {
/* 449 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/*     */       
/* 451 */       TransferOccupationFashionDress _o_ = TransferOccupationFashionDress.this;
/* 452 */       Map<Integer, xbean.FashionDressInfo> fashion_dress_map = new HashMap();
/* 453 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/* 454 */         fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/* 455 */       return fashion_dress_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getActivate_property_set()
/*     */     {
/* 462 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 463 */       return xdb.Consts.constSet(TransferOccupationFashionDress.this.activate_property_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getActivate_property_setAsData()
/*     */     {
/* 469 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/*     */       
/* 471 */       TransferOccupationFashionDress _o_ = TransferOccupationFashionDress.this;
/* 472 */       Set<Integer> activate_property_set = new SetX();
/* 473 */       activate_property_set.addAll(_o_.activate_property_set);
/* 474 */       return activate_property_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurrent_fashion_dress_cfg_id(int _v_)
/*     */     {
/* 481 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 488 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 489 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 495 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 496 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 502 */       return TransferOccupationFashionDress.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 508 */       return TransferOccupationFashionDress.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 514 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 521 */       return TransferOccupationFashionDress.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 527 */       return TransferOccupationFashionDress.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 533 */       TransferOccupationFashionDress.this._xdb_verify_unsafe_();
/* 534 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 540 */       return TransferOccupationFashionDress.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 546 */       return TransferOccupationFashionDress.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 552 */       return TransferOccupationFashionDress.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 558 */       return TransferOccupationFashionDress.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 564 */       return TransferOccupationFashionDress.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 570 */       return TransferOccupationFashionDress.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 576 */       return TransferOccupationFashionDress.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TransferOccupationFashionDress
/*     */   {
/*     */     private int current_fashion_dress_cfg_id;
/*     */     
/*     */     private HashMap<Integer, xbean.FashionDressInfo> fashion_dress_map;
/*     */     
/*     */     private HashSet<Integer> activate_property_set;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 597 */       this.fashion_dress_map = new HashMap();
/* 598 */       this.activate_property_set = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.TransferOccupationFashionDress _o1_)
/*     */     {
/* 603 */       if ((_o1_ instanceof TransferOccupationFashionDress)) { assign((TransferOccupationFashionDress)_o1_);
/* 604 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 605 */       } else if ((_o1_ instanceof TransferOccupationFashionDress.Const)) assign(((TransferOccupationFashionDress.Const)_o1_).nThis()); else {
/* 606 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(TransferOccupationFashionDress _o_) {
/* 611 */       this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/* 612 */       this.fashion_dress_map = new HashMap();
/* 613 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/* 614 */         this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/* 615 */       this.activate_property_set = new HashSet();
/* 616 */       this.activate_property_set.addAll(_o_.activate_property_set);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 621 */       this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/* 622 */       this.fashion_dress_map = new HashMap();
/* 623 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/* 624 */         this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/* 625 */       this.activate_property_set = new HashSet();
/* 626 */       this.activate_property_set.addAll(_o_.activate_property_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 632 */       _os_.marshal(this.current_fashion_dress_cfg_id);
/* 633 */       _os_.compact_uint32(this.fashion_dress_map.size());
/* 634 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*     */       {
/* 636 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 637 */         ((xbean.FashionDressInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 639 */       _os_.compact_uint32(this.activate_property_set.size());
/* 640 */       for (Integer _v_ : this.activate_property_set)
/*     */       {
/* 642 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 644 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 650 */       this.current_fashion_dress_cfg_id = _os_.unmarshal_int();
/*     */       
/* 652 */       int size = _os_.uncompact_uint32();
/* 653 */       if (size >= 12)
/*     */       {
/* 655 */         this.fashion_dress_map = new HashMap(size * 2);
/*     */       }
/* 657 */       for (; size > 0; size--)
/*     */       {
/* 659 */         int _k_ = 0;
/* 660 */         _k_ = _os_.unmarshal_int();
/* 661 */         xbean.FashionDressInfo _v_ = xbean.Pod.newFashionDressInfoData();
/* 662 */         _v_.unmarshal(_os_);
/* 663 */         this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 666 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 668 */         int _v_ = 0;
/* 669 */         _v_ = _os_.unmarshal_int();
/* 670 */         this.activate_property_set.add(Integer.valueOf(_v_));
/*     */       }
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 678 */       int _size_ = 0;
/* 679 */       _size_ += CodedOutputStream.computeInt32Size(1, this.current_fashion_dress_cfg_id);
/* 680 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*     */       {
/* 682 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 683 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 685 */       for (Integer _v_ : this.activate_property_set)
/*     */       {
/* 687 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 689 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 697 */         _output_.writeInt32(1, this.current_fashion_dress_cfg_id);
/* 698 */         for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*     */         {
/* 700 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 701 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 703 */         for (Integer _v_ : this.activate_property_set)
/*     */         {
/* 705 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 710 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 712 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 720 */         boolean done = false;
/* 721 */         while (!done)
/*     */         {
/* 723 */           int tag = _input_.readTag();
/* 724 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 728 */             done = true;
/* 729 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 733 */             this.current_fashion_dress_cfg_id = _input_.readInt32();
/* 734 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 738 */             int _k_ = 0;
/* 739 */             _k_ = _input_.readInt32();
/* 740 */             int readTag = _input_.readTag();
/* 741 */             if (18 != readTag)
/*     */             {
/* 743 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 745 */             xbean.FashionDressInfo _v_ = xbean.Pod.newFashionDressInfoData();
/* 746 */             _input_.readMessage(_v_);
/* 747 */             this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/* 748 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 752 */             int _v_ = 0;
/* 753 */             _v_ = _input_.readInt32();
/* 754 */             this.activate_property_set.add(Integer.valueOf(_v_));
/* 755 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 759 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 761 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 770 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 774 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 776 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationFashionDress copy()
/*     */     {
/* 782 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationFashionDress toData()
/*     */     {
/* 788 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationFashionDress toBean()
/*     */     {
/* 793 */       return new TransferOccupationFashionDress(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationFashionDress toDataIf()
/*     */     {
/* 799 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationFashionDress toBeanIf()
/*     */     {
/* 804 */       return new TransferOccupationFashionDress(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 810 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 814 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 818 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 822 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 826 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 830 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 834 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurrent_fashion_dress_cfg_id()
/*     */     {
/* 841 */       return this.current_fashion_dress_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_map()
/*     */     {
/* 848 */       return this.fashion_dress_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_mapAsData()
/*     */     {
/* 855 */       return this.fashion_dress_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getActivate_property_set()
/*     */     {
/* 862 */       return this.activate_property_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getActivate_property_setAsData()
/*     */     {
/* 869 */       return this.activate_property_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurrent_fashion_dress_cfg_id(int _v_)
/*     */     {
/* 876 */       this.current_fashion_dress_cfg_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 882 */       if (!(_o1_ instanceof Data)) return false;
/* 883 */       Data _o_ = (Data)_o1_;
/* 884 */       if (this.current_fashion_dress_cfg_id != _o_.current_fashion_dress_cfg_id) return false;
/* 885 */       if (!this.fashion_dress_map.equals(_o_.fashion_dress_map)) return false;
/* 886 */       if (!this.activate_property_set.equals(_o_.activate_property_set)) return false;
/* 887 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 893 */       int _h_ = 0;
/* 894 */       _h_ += this.current_fashion_dress_cfg_id;
/* 895 */       _h_ += this.fashion_dress_map.hashCode();
/* 896 */       _h_ += this.activate_property_set.hashCode();
/* 897 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 903 */       StringBuilder _sb_ = new StringBuilder();
/* 904 */       _sb_.append("(");
/* 905 */       _sb_.append(this.current_fashion_dress_cfg_id);
/* 906 */       _sb_.append(",");
/* 907 */       _sb_.append(this.fashion_dress_map);
/* 908 */       _sb_.append(",");
/* 909 */       _sb_.append(this.activate_property_set);
/* 910 */       _sb_.append(")");
/* 911 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TransferOccupationFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */