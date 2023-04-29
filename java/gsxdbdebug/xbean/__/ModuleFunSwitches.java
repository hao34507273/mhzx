/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class ModuleFunSwitches extends xdb.XBean implements xbean.ModuleFunSwitches
/*     */ {
/*     */   private HashMap<Integer, xbean.ModuleFunSwitchInfo> fun_switch_infos;
/*     */   private SetX<Integer> fun_switch_init_infos;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.fun_switch_infos.clear();
/*  21 */     this.fun_switch_init_infos.clear();
/*     */   }
/*     */   
/*     */   ModuleFunSwitches(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.fun_switch_infos = new HashMap();
/*  28 */     this.fun_switch_init_infos = new SetX();
/*     */   }
/*     */   
/*     */   public ModuleFunSwitches()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ModuleFunSwitches(ModuleFunSwitches _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ModuleFunSwitches(xbean.ModuleFunSwitches _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof ModuleFunSwitches)) { assign((ModuleFunSwitches)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ModuleFunSwitches _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.fun_switch_infos = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : _o_.fun_switch_infos.entrySet())
/*  55 */       this.fun_switch_infos.put(_e_.getKey(), new ModuleFunSwitchInfo((xbean.ModuleFunSwitchInfo)_e_.getValue(), this, "fun_switch_infos"));
/*  56 */     this.fun_switch_init_infos = new SetX();
/*  57 */     this.fun_switch_init_infos.addAll(_o_.fun_switch_init_infos);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.fun_switch_infos = new HashMap();
/*  63 */     for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : _o_.fun_switch_infos.entrySet())
/*  64 */       this.fun_switch_infos.put(_e_.getKey(), new ModuleFunSwitchInfo((xbean.ModuleFunSwitchInfo)_e_.getValue(), this, "fun_switch_infos"));
/*  65 */     this.fun_switch_init_infos = new SetX();
/*  66 */     this.fun_switch_init_infos.addAll(_o_.fun_switch_init_infos);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.compact_uint32(this.fun_switch_infos.size());
/*  74 */     for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : this.fun_switch_infos.entrySet())
/*     */     {
/*  76 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  77 */       ((xbean.ModuleFunSwitchInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  79 */     _os_.compact_uint32(this.fun_switch_init_infos.size());
/*  80 */     for (Integer _v_ : this.fun_switch_init_infos)
/*     */     {
/*  82 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*     */     
/*  92 */     int size = _os_.uncompact_uint32();
/*  93 */     if (size >= 12)
/*     */     {
/*  95 */       this.fun_switch_infos = new HashMap(size * 2);
/*     */     }
/*  97 */     for (; size > 0; size--)
/*     */     {
/*  99 */       int _k_ = 0;
/* 100 */       _k_ = _os_.unmarshal_int();
/* 101 */       xbean.ModuleFunSwitchInfo _v_ = new ModuleFunSwitchInfo(0, this, "fun_switch_infos");
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.fun_switch_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 106 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 108 */       int _v_ = 0;
/* 109 */       _v_ = _os_.unmarshal_int();
/* 110 */       this.fun_switch_init_infos.add(Integer.valueOf(_v_));
/*     */     }
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     int _size_ = 0;
/* 120 */     for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : this.fun_switch_infos.entrySet())
/*     */     {
/* 122 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 123 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 125 */     for (Integer _v_ : this.fun_switch_init_infos)
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 129 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : this.fun_switch_infos.entrySet())
/*     */       {
/* 140 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 141 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 143 */       for (Integer _v_ : this.fun_switch_init_infos)
/*     */       {
/* 145 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           int _k_ = 0;
/* 175 */           _k_ = _input_.readInt32();
/* 176 */           int readTag = _input_.readTag();
/* 177 */           if (10 != readTag)
/*     */           {
/* 179 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 181 */           xbean.ModuleFunSwitchInfo _v_ = new ModuleFunSwitchInfo(0, this, "fun_switch_infos");
/* 182 */           _input_.readMessage(_v_);
/* 183 */           this.fun_switch_infos.put(Integer.valueOf(_k_), _v_);
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 188 */           int _v_ = 0;
/* 189 */           _v_ = _input_.readInt32();
/* 190 */           this.fun_switch_init_infos.add(Integer.valueOf(_v_));
/* 191 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 195 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 197 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 206 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 210 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 212 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ModuleFunSwitches copy()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new ModuleFunSwitches(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ModuleFunSwitches toData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ModuleFunSwitches toBean()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new ModuleFunSwitches(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ModuleFunSwitches toDataIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ModuleFunSwitches toBeanIf()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Integer, xbean.ModuleFunSwitchInfo> getFun_switch_infos()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return xdb.Logs.logMap(new xdb.LogKey(this, "fun_switch_infos"), this.fun_switch_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Integer, xbean.ModuleFunSwitchInfo> getFun_switch_infosAsData()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/*     */     
/* 269 */     ModuleFunSwitches _o_ = this;
/* 270 */     java.util.Map<Integer, xbean.ModuleFunSwitchInfo> fun_switch_infos = new HashMap();
/* 271 */     for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : _o_.fun_switch_infos.entrySet())
/* 272 */       fun_switch_infos.put(_e_.getKey(), new ModuleFunSwitchInfo.Data((xbean.ModuleFunSwitchInfo)_e_.getValue()));
/* 273 */     return fun_switch_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getFun_switch_init_infos()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logSet(new xdb.LogKey(this, "fun_switch_init_infos"), this.fun_switch_init_infos);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getFun_switch_init_infosAsData()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/*     */     
/* 289 */     ModuleFunSwitches _o_ = this;
/* 290 */     Set<Integer> fun_switch_init_infos = new SetX();
/* 291 */     fun_switch_init_infos.addAll(_o_.fun_switch_init_infos);
/* 292 */     return fun_switch_init_infos;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     ModuleFunSwitches _o_ = null;
/* 300 */     if ((_o1_ instanceof ModuleFunSwitches)) { _o_ = (ModuleFunSwitches)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (!this.fun_switch_infos.equals(_o_.fun_switch_infos)) return false;
/* 304 */     if (!this.fun_switch_init_infos.equals(_o_.fun_switch_init_infos)) return false;
/* 305 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     int _h_ = 0;
/* 313 */     _h_ += this.fun_switch_infos.hashCode();
/* 314 */     _h_ += this.fun_switch_init_infos.hashCode();
/* 315 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     StringBuilder _sb_ = new StringBuilder();
/* 323 */     _sb_.append("(");
/* 324 */     _sb_.append(this.fun_switch_infos);
/* 325 */     _sb_.append(",");
/* 326 */     _sb_.append(this.fun_switch_init_infos);
/* 327 */     _sb_.append(")");
/* 328 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 334 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 335 */     lb.add(new xdb.logs.ListenableMap().setVarName("fun_switch_infos"));
/* 336 */     lb.add(new xdb.logs.ListenableSet().setVarName("fun_switch_init_infos"));
/* 337 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ModuleFunSwitches {
/*     */     private Const() {}
/*     */     
/*     */     ModuleFunSwitches nThis() {
/* 344 */       return ModuleFunSwitches.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 350 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ModuleFunSwitches copy()
/*     */     {
/* 356 */       return ModuleFunSwitches.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ModuleFunSwitches toData()
/*     */     {
/* 362 */       return ModuleFunSwitches.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ModuleFunSwitches toBean()
/*     */     {
/* 367 */       return ModuleFunSwitches.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ModuleFunSwitches toDataIf()
/*     */     {
/* 373 */       return ModuleFunSwitches.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ModuleFunSwitches toBeanIf()
/*     */     {
/* 378 */       return ModuleFunSwitches.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.ModuleFunSwitchInfo> getFun_switch_infos()
/*     */     {
/* 385 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/* 386 */       return xdb.Consts.constMap(ModuleFunSwitches.this.fun_switch_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.ModuleFunSwitchInfo> getFun_switch_infosAsData()
/*     */     {
/* 393 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/*     */       
/* 395 */       ModuleFunSwitches _o_ = ModuleFunSwitches.this;
/* 396 */       java.util.Map<Integer, xbean.ModuleFunSwitchInfo> fun_switch_infos = new HashMap();
/* 397 */       for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : _o_.fun_switch_infos.entrySet())
/* 398 */         fun_switch_infos.put(_e_.getKey(), new ModuleFunSwitchInfo.Data((xbean.ModuleFunSwitchInfo)_e_.getValue()));
/* 399 */       return fun_switch_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getFun_switch_init_infos()
/*     */     {
/* 406 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/* 407 */       return xdb.Consts.constSet(ModuleFunSwitches.this.fun_switch_init_infos);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getFun_switch_init_infosAsData()
/*     */     {
/* 413 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/*     */       
/* 415 */       ModuleFunSwitches _o_ = ModuleFunSwitches.this;
/* 416 */       Set<Integer> fun_switch_init_infos = new SetX();
/* 417 */       fun_switch_init_infos.addAll(_o_.fun_switch_init_infos);
/* 418 */       return fun_switch_init_infos;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 424 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/* 425 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 431 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/* 432 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 438 */       return ModuleFunSwitches.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 444 */       return ModuleFunSwitches.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 450 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 457 */       return ModuleFunSwitches.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 463 */       return ModuleFunSwitches.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 469 */       ModuleFunSwitches.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 476 */       return ModuleFunSwitches.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 482 */       return ModuleFunSwitches.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 488 */       return ModuleFunSwitches.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 494 */       return ModuleFunSwitches.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 500 */       return ModuleFunSwitches.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 506 */       return ModuleFunSwitches.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 512 */       return ModuleFunSwitches.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ModuleFunSwitches
/*     */   {
/*     */     private HashMap<Integer, xbean.ModuleFunSwitchInfo> fun_switch_infos;
/*     */     
/*     */     private HashSet<Integer> fun_switch_init_infos;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 526 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 531 */       this.fun_switch_infos = new HashMap();
/* 532 */       this.fun_switch_init_infos = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.ModuleFunSwitches _o1_)
/*     */     {
/* 537 */       if ((_o1_ instanceof ModuleFunSwitches)) { assign((ModuleFunSwitches)_o1_);
/* 538 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 539 */       } else if ((_o1_ instanceof ModuleFunSwitches.Const)) assign(((ModuleFunSwitches.Const)_o1_).nThis()); else {
/* 540 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ModuleFunSwitches _o_) {
/* 545 */       this.fun_switch_infos = new HashMap();
/* 546 */       for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : _o_.fun_switch_infos.entrySet())
/* 547 */         this.fun_switch_infos.put(_e_.getKey(), new ModuleFunSwitchInfo.Data((xbean.ModuleFunSwitchInfo)_e_.getValue()));
/* 548 */       this.fun_switch_init_infos = new HashSet();
/* 549 */       this.fun_switch_init_infos.addAll(_o_.fun_switch_init_infos);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 554 */       this.fun_switch_infos = new HashMap();
/* 555 */       for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : _o_.fun_switch_infos.entrySet())
/* 556 */         this.fun_switch_infos.put(_e_.getKey(), new ModuleFunSwitchInfo.Data((xbean.ModuleFunSwitchInfo)_e_.getValue()));
/* 557 */       this.fun_switch_init_infos = new HashSet();
/* 558 */       this.fun_switch_init_infos.addAll(_o_.fun_switch_init_infos);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 564 */       _os_.compact_uint32(this.fun_switch_infos.size());
/* 565 */       for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : this.fun_switch_infos.entrySet())
/*     */       {
/* 567 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 568 */         ((xbean.ModuleFunSwitchInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 570 */       _os_.compact_uint32(this.fun_switch_init_infos.size());
/* 571 */       for (Integer _v_ : this.fun_switch_init_infos)
/*     */       {
/* 573 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 575 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       int size = _os_.uncompact_uint32();
/* 583 */       if (size >= 12)
/*     */       {
/* 585 */         this.fun_switch_infos = new HashMap(size * 2);
/*     */       }
/* 587 */       for (; size > 0; size--)
/*     */       {
/* 589 */         int _k_ = 0;
/* 590 */         _k_ = _os_.unmarshal_int();
/* 591 */         xbean.ModuleFunSwitchInfo _v_ = xbean.Pod.newModuleFunSwitchInfoData();
/* 592 */         _v_.unmarshal(_os_);
/* 593 */         this.fun_switch_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 596 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 598 */         int _v_ = 0;
/* 599 */         _v_ = _os_.unmarshal_int();
/* 600 */         this.fun_switch_init_infos.add(Integer.valueOf(_v_));
/*     */       }
/* 602 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 608 */       int _size_ = 0;
/* 609 */       for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : this.fun_switch_infos.entrySet())
/*     */       {
/* 611 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 612 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 614 */       for (Integer _v_ : this.fun_switch_init_infos)
/*     */       {
/* 616 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 618 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 626 */         for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> _e_ : this.fun_switch_infos.entrySet())
/*     */         {
/* 628 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 629 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 631 */         for (Integer _v_ : this.fun_switch_init_infos)
/*     */         {
/* 633 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 638 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 640 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 648 */         boolean done = false;
/* 649 */         while (!done)
/*     */         {
/* 651 */           int tag = _input_.readTag();
/* 652 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 656 */             done = true;
/* 657 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 661 */             int _k_ = 0;
/* 662 */             _k_ = _input_.readInt32();
/* 663 */             int readTag = _input_.readTag();
/* 664 */             if (10 != readTag)
/*     */             {
/* 666 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 668 */             xbean.ModuleFunSwitchInfo _v_ = xbean.Pod.newModuleFunSwitchInfoData();
/* 669 */             _input_.readMessage(_v_);
/* 670 */             this.fun_switch_infos.put(Integer.valueOf(_k_), _v_);
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 675 */             int _v_ = 0;
/* 676 */             _v_ = _input_.readInt32();
/* 677 */             this.fun_switch_init_infos.add(Integer.valueOf(_v_));
/* 678 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 682 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 684 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 693 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 697 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 699 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ModuleFunSwitches copy()
/*     */     {
/* 705 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ModuleFunSwitches toData()
/*     */     {
/* 711 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ModuleFunSwitches toBean()
/*     */     {
/* 716 */       return new ModuleFunSwitches(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ModuleFunSwitches toDataIf()
/*     */     {
/* 722 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ModuleFunSwitches toBeanIf()
/*     */     {
/* 727 */       return new ModuleFunSwitches(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 733 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 753 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 757 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.ModuleFunSwitchInfo> getFun_switch_infos()
/*     */     {
/* 764 */       return this.fun_switch_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.ModuleFunSwitchInfo> getFun_switch_infosAsData()
/*     */     {
/* 771 */       return this.fun_switch_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getFun_switch_init_infos()
/*     */     {
/* 778 */       return this.fun_switch_init_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getFun_switch_init_infosAsData()
/*     */     {
/* 785 */       return this.fun_switch_init_infos;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 791 */       if (!(_o1_ instanceof Data)) return false;
/* 792 */       Data _o_ = (Data)_o1_;
/* 793 */       if (!this.fun_switch_infos.equals(_o_.fun_switch_infos)) return false;
/* 794 */       if (!this.fun_switch_init_infos.equals(_o_.fun_switch_init_infos)) return false;
/* 795 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 801 */       int _h_ = 0;
/* 802 */       _h_ += this.fun_switch_infos.hashCode();
/* 803 */       _h_ += this.fun_switch_init_infos.hashCode();
/* 804 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 810 */       StringBuilder _sb_ = new StringBuilder();
/* 811 */       _sb_.append("(");
/* 812 */       _sb_.append(this.fun_switch_infos);
/* 813 */       _sb_.append(",");
/* 814 */       _sb_.append(this.fun_switch_init_infos);
/* 815 */       _sb_.append(")");
/* 816 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ModuleFunSwitches.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */