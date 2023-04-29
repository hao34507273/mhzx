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
/*     */ import ppbio.Message;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class InstanceBean extends XBean implements xbean.InstanceBean
/*     */ {
/*     */   private HashMap<Integer, xbean.SingleInstance> singleinstancemap;
/*     */   private int singlefailtime;
/*     */   private HashMap<Integer, xbean.TeamInstance> teaminstancemap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.singleinstancemap.clear();
/*  23 */     this.singlefailtime = 0;
/*  24 */     this.teaminstancemap.clear();
/*     */   }
/*     */   
/*     */   InstanceBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.singleinstancemap = new HashMap();
/*  31 */     this.teaminstancemap = new HashMap();
/*     */   }
/*     */   
/*     */   public InstanceBean()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public InstanceBean(InstanceBean _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   InstanceBean(xbean.InstanceBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof InstanceBean)) { assign((InstanceBean)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(InstanceBean _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.singleinstancemap = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.SingleInstance> _e_ : _o_.singleinstancemap.entrySet())
/*  58 */       this.singleinstancemap.put(_e_.getKey(), new SingleInstance((xbean.SingleInstance)_e_.getValue(), this, "singleinstancemap"));
/*  59 */     this.singlefailtime = _o_.singlefailtime;
/*  60 */     this.teaminstancemap = new HashMap();
/*  61 */     for (Map.Entry<Integer, xbean.TeamInstance> _e_ : _o_.teaminstancemap.entrySet()) {
/*  62 */       this.teaminstancemap.put(_e_.getKey(), new TeamInstance((xbean.TeamInstance)_e_.getValue(), this, "teaminstancemap"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.singleinstancemap = new HashMap();
/*  68 */     for (Map.Entry<Integer, xbean.SingleInstance> _e_ : _o_.singleinstancemap.entrySet())
/*  69 */       this.singleinstancemap.put(_e_.getKey(), new SingleInstance((xbean.SingleInstance)_e_.getValue(), this, "singleinstancemap"));
/*  70 */     this.singlefailtime = _o_.singlefailtime;
/*  71 */     this.teaminstancemap = new HashMap();
/*  72 */     for (Map.Entry<Integer, xbean.TeamInstance> _e_ : _o_.teaminstancemap.entrySet()) {
/*  73 */       this.teaminstancemap.put(_e_.getKey(), new TeamInstance((xbean.TeamInstance)_e_.getValue(), this, "teaminstancemap"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.singleinstancemap.size());
/*  81 */     for (Map.Entry<Integer, xbean.SingleInstance> _e_ : this.singleinstancemap.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  84 */       ((xbean.SingleInstance)_e_.getValue()).marshal(_os_);
/*     */     }
/*  86 */     _os_.marshal(this.singlefailtime);
/*  87 */     _os_.compact_uint32(this.teaminstancemap.size());
/*  88 */     for (Map.Entry<Integer, xbean.TeamInstance> _e_ : this.teaminstancemap.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  91 */       ((xbean.TeamInstance)_e_.getValue()).marshal(_os_);
/*     */     }
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
/* 104 */       this.singleinstancemap = new HashMap(size * 2);
/*     */     }
/* 106 */     for (; size > 0; size--)
/*     */     {
/* 108 */       int _k_ = 0;
/* 109 */       _k_ = _os_.unmarshal_int();
/* 110 */       xbean.SingleInstance _v_ = new SingleInstance(0, this, "singleinstancemap");
/* 111 */       _v_.unmarshal(_os_);
/* 112 */       this.singleinstancemap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 115 */     this.singlefailtime = _os_.unmarshal_int();
/*     */     
/* 117 */     int size = _os_.uncompact_uint32();
/* 118 */     if (size >= 12)
/*     */     {
/* 120 */       this.teaminstancemap = new HashMap(size * 2);
/*     */     }
/* 122 */     for (; size > 0; size--)
/*     */     {
/* 124 */       int _k_ = 0;
/* 125 */       _k_ = _os_.unmarshal_int();
/* 126 */       xbean.TeamInstance _v_ = new TeamInstance(0, this, "teaminstancemap");
/* 127 */       _v_.unmarshal(_os_);
/* 128 */       this.teaminstancemap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     for (Map.Entry<Integer, xbean.SingleInstance> _e_ : this.singleinstancemap.entrySet())
/*     */     {
/* 141 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 142 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */     }
/* 144 */     _size_ += CodedOutputStream.computeInt32Size(2, this.singlefailtime);
/* 145 */     for (Map.Entry<Integer, xbean.TeamInstance> _e_ : this.teaminstancemap.entrySet())
/*     */     {
/* 147 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 148 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*     */     }
/* 150 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 159 */       for (Map.Entry<Integer, xbean.SingleInstance> _e_ : this.singleinstancemap.entrySet())
/*     */       {
/* 161 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 162 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*     */       }
/* 164 */       _output_.writeInt32(2, this.singlefailtime);
/* 165 */       for (Map.Entry<Integer, xbean.TeamInstance> _e_ : this.teaminstancemap.entrySet())
/*     */       {
/* 167 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 168 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*     */       }
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
/* 197 */           int _k_ = 0;
/* 198 */           _k_ = _input_.readInt32();
/* 199 */           int readTag = _input_.readTag();
/* 200 */           if (10 != readTag)
/*     */           {
/* 202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 204 */           xbean.SingleInstance _v_ = new SingleInstance(0, this, "singleinstancemap");
/* 205 */           _input_.readMessage(_v_);
/* 206 */           this.singleinstancemap.put(Integer.valueOf(_k_), _v_);
/* 207 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 211 */           this.singlefailtime = _input_.readInt32();
/* 212 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 216 */           int _k_ = 0;
/* 217 */           _k_ = _input_.readInt32();
/* 218 */           int readTag = _input_.readTag();
/* 219 */           if (26 != readTag)
/*     */           {
/* 221 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 223 */           xbean.TeamInstance _v_ = new TeamInstance(0, this, "teaminstancemap");
/* 224 */           _input_.readMessage(_v_);
/* 225 */           this.teaminstancemap.put(Integer.valueOf(_k_), _v_);
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
/*     */   public xbean.InstanceBean copy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new InstanceBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InstanceBean toData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.InstanceBean toBean()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new InstanceBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InstanceBean toDataIf()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.InstanceBean toBeanIf()
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
/*     */   public Map<Integer, xbean.SingleInstance> getSingleinstancemap()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return xdb.Logs.logMap(new xdb.LogKey(this, "singleinstancemap"), this.singleinstancemap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.SingleInstance> getSingleinstancemapAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     InstanceBean _o_ = this;
/* 305 */     Map<Integer, xbean.SingleInstance> singleinstancemap = new HashMap();
/* 306 */     for (Map.Entry<Integer, xbean.SingleInstance> _e_ : _o_.singleinstancemap.entrySet())
/* 307 */       singleinstancemap.put(_e_.getKey(), new SingleInstance.Data((xbean.SingleInstance)_e_.getValue()));
/* 308 */     return singleinstancemap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSinglefailtime()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     return this.singlefailtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TeamInstance> getTeaminstancemap()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     return xdb.Logs.logMap(new xdb.LogKey(this, "teaminstancemap"), this.teaminstancemap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TeamInstance> getTeaminstancemapAsData()
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/*     */     
/* 333 */     InstanceBean _o_ = this;
/* 334 */     Map<Integer, xbean.TeamInstance> teaminstancemap = new HashMap();
/* 335 */     for (Map.Entry<Integer, xbean.TeamInstance> _e_ : _o_.teaminstancemap.entrySet())
/* 336 */       teaminstancemap.put(_e_.getKey(), new TeamInstance.Data((xbean.TeamInstance)_e_.getValue()));
/* 337 */     return teaminstancemap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSinglefailtime(int _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new xdb.LogKey(this, "singlefailtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 349 */         new xdb.logs.LogInt(this, InstanceBean.this.singlefailtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             InstanceBean.this.singlefailtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.singlefailtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     InstanceBean _o_ = null;
/* 366 */     if ((_o1_ instanceof InstanceBean)) { _o_ = (InstanceBean)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (!this.singleinstancemap.equals(_o_.singleinstancemap)) return false;
/* 370 */     if (this.singlefailtime != _o_.singlefailtime) return false;
/* 371 */     if (!this.teaminstancemap.equals(_o_.teaminstancemap)) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ += this.singleinstancemap.hashCode();
/* 381 */     _h_ += this.singlefailtime;
/* 382 */     _h_ += this.teaminstancemap.hashCode();
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.singleinstancemap);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.singlefailtime);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.teaminstancemap);
/* 397 */     _sb_.append(")");
/* 398 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 404 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 405 */     lb.add(new xdb.logs.ListenableMap().setVarName("singleinstancemap"));
/* 406 */     lb.add(new xdb.logs.ListenableChanged().setVarName("singlefailtime"));
/* 407 */     lb.add(new xdb.logs.ListenableMap().setVarName("teaminstancemap"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.InstanceBean {
/*     */     private Const() {}
/*     */     
/*     */     InstanceBean nThis() {
/* 415 */       return InstanceBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InstanceBean copy()
/*     */     {
/* 427 */       return InstanceBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InstanceBean toData()
/*     */     {
/* 433 */       return InstanceBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.InstanceBean toBean()
/*     */     {
/* 438 */       return InstanceBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InstanceBean toDataIf()
/*     */     {
/* 444 */       return InstanceBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.InstanceBean toBeanIf()
/*     */     {
/* 449 */       return InstanceBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SingleInstance> getSingleinstancemap()
/*     */     {
/* 456 */       InstanceBean.this._xdb_verify_unsafe_();
/* 457 */       return xdb.Consts.constMap(InstanceBean.this.singleinstancemap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SingleInstance> getSingleinstancemapAsData()
/*     */     {
/* 464 */       InstanceBean.this._xdb_verify_unsafe_();
/*     */       
/* 466 */       InstanceBean _o_ = InstanceBean.this;
/* 467 */       Map<Integer, xbean.SingleInstance> singleinstancemap = new HashMap();
/* 468 */       for (Map.Entry<Integer, xbean.SingleInstance> _e_ : _o_.singleinstancemap.entrySet())
/* 469 */         singleinstancemap.put(_e_.getKey(), new SingleInstance.Data((xbean.SingleInstance)_e_.getValue()));
/* 470 */       return singleinstancemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSinglefailtime()
/*     */     {
/* 477 */       InstanceBean.this._xdb_verify_unsafe_();
/* 478 */       return InstanceBean.this.singlefailtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TeamInstance> getTeaminstancemap()
/*     */     {
/* 485 */       InstanceBean.this._xdb_verify_unsafe_();
/* 486 */       return xdb.Consts.constMap(InstanceBean.this.teaminstancemap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TeamInstance> getTeaminstancemapAsData()
/*     */     {
/* 493 */       InstanceBean.this._xdb_verify_unsafe_();
/*     */       
/* 495 */       InstanceBean _o_ = InstanceBean.this;
/* 496 */       Map<Integer, xbean.TeamInstance> teaminstancemap = new HashMap();
/* 497 */       for (Map.Entry<Integer, xbean.TeamInstance> _e_ : _o_.teaminstancemap.entrySet())
/* 498 */         teaminstancemap.put(_e_.getKey(), new TeamInstance.Data((xbean.TeamInstance)_e_.getValue()));
/* 499 */       return teaminstancemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSinglefailtime(int _v_)
/*     */     {
/* 506 */       InstanceBean.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 513 */       InstanceBean.this._xdb_verify_unsafe_();
/* 514 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 520 */       InstanceBean.this._xdb_verify_unsafe_();
/* 521 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 527 */       return InstanceBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 533 */       return InstanceBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       InstanceBean.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 546 */       return InstanceBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 552 */       return InstanceBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 558 */       InstanceBean.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 565 */       return InstanceBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 571 */       return InstanceBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 577 */       return InstanceBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 583 */       return InstanceBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 589 */       return InstanceBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 595 */       return InstanceBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 601 */       return InstanceBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.InstanceBean
/*     */   {
/*     */     private HashMap<Integer, xbean.SingleInstance> singleinstancemap;
/*     */     
/*     */     private int singlefailtime;
/*     */     
/*     */     private HashMap<Integer, xbean.TeamInstance> teaminstancemap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.singleinstancemap = new HashMap();
/* 623 */       this.teaminstancemap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.InstanceBean _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof InstanceBean)) { assign((InstanceBean)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof InstanceBean.Const)) assign(((InstanceBean.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(InstanceBean _o_) {
/* 636 */       this.singleinstancemap = new HashMap();
/* 637 */       for (Map.Entry<Integer, xbean.SingleInstance> _e_ : _o_.singleinstancemap.entrySet())
/* 638 */         this.singleinstancemap.put(_e_.getKey(), new SingleInstance.Data((xbean.SingleInstance)_e_.getValue()));
/* 639 */       this.singlefailtime = _o_.singlefailtime;
/* 640 */       this.teaminstancemap = new HashMap();
/* 641 */       for (Map.Entry<Integer, xbean.TeamInstance> _e_ : _o_.teaminstancemap.entrySet()) {
/* 642 */         this.teaminstancemap.put(_e_.getKey(), new TeamInstance.Data((xbean.TeamInstance)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 647 */       this.singleinstancemap = new HashMap();
/* 648 */       for (Map.Entry<Integer, xbean.SingleInstance> _e_ : _o_.singleinstancemap.entrySet())
/* 649 */         this.singleinstancemap.put(_e_.getKey(), new SingleInstance.Data((xbean.SingleInstance)_e_.getValue()));
/* 650 */       this.singlefailtime = _o_.singlefailtime;
/* 651 */       this.teaminstancemap = new HashMap();
/* 652 */       for (Map.Entry<Integer, xbean.TeamInstance> _e_ : _o_.teaminstancemap.entrySet()) {
/* 653 */         this.teaminstancemap.put(_e_.getKey(), new TeamInstance.Data((xbean.TeamInstance)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.compact_uint32(this.singleinstancemap.size());
/* 660 */       for (Map.Entry<Integer, xbean.SingleInstance> _e_ : this.singleinstancemap.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 663 */         ((xbean.SingleInstance)_e_.getValue()).marshal(_os_);
/*     */       }
/* 665 */       _os_.marshal(this.singlefailtime);
/* 666 */       _os_.compact_uint32(this.teaminstancemap.size());
/* 667 */       for (Map.Entry<Integer, xbean.TeamInstance> _e_ : this.teaminstancemap.entrySet())
/*     */       {
/* 669 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 670 */         ((xbean.TeamInstance)_e_.getValue()).marshal(_os_);
/*     */       }
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
/* 682 */         this.singleinstancemap = new HashMap(size * 2);
/*     */       }
/* 684 */       for (; size > 0; size--)
/*     */       {
/* 686 */         int _k_ = 0;
/* 687 */         _k_ = _os_.unmarshal_int();
/* 688 */         xbean.SingleInstance _v_ = xbean.Pod.newSingleInstanceData();
/* 689 */         _v_.unmarshal(_os_);
/* 690 */         this.singleinstancemap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 693 */       this.singlefailtime = _os_.unmarshal_int();
/*     */       
/* 695 */       int size = _os_.uncompact_uint32();
/* 696 */       if (size >= 12)
/*     */       {
/* 698 */         this.teaminstancemap = new HashMap(size * 2);
/*     */       }
/* 700 */       for (; size > 0; size--)
/*     */       {
/* 702 */         int _k_ = 0;
/* 703 */         _k_ = _os_.unmarshal_int();
/* 704 */         xbean.TeamInstance _v_ = xbean.Pod.newTeamInstanceData();
/* 705 */         _v_.unmarshal(_os_);
/* 706 */         this.teaminstancemap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       for (Map.Entry<Integer, xbean.SingleInstance> _e_ : this.singleinstancemap.entrySet())
/*     */       {
/* 718 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 719 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*     */       }
/* 721 */       _size_ += CodedOutputStream.computeInt32Size(2, this.singlefailtime);
/* 722 */       for (Map.Entry<Integer, xbean.TeamInstance> _e_ : this.teaminstancemap.entrySet())
/*     */       {
/* 724 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 725 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*     */       }
/* 727 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 735 */         for (Map.Entry<Integer, xbean.SingleInstance> _e_ : this.singleinstancemap.entrySet())
/*     */         {
/* 737 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 738 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*     */         }
/* 740 */         _output_.writeInt32(2, this.singlefailtime);
/* 741 */         for (Map.Entry<Integer, xbean.TeamInstance> _e_ : this.teaminstancemap.entrySet())
/*     */         {
/* 743 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 744 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*     */         }
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
/* 772 */             int _k_ = 0;
/* 773 */             _k_ = _input_.readInt32();
/* 774 */             int readTag = _input_.readTag();
/* 775 */             if (10 != readTag)
/*     */             {
/* 777 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 779 */             xbean.SingleInstance _v_ = xbean.Pod.newSingleInstanceData();
/* 780 */             _input_.readMessage(_v_);
/* 781 */             this.singleinstancemap.put(Integer.valueOf(_k_), _v_);
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 786 */             this.singlefailtime = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 791 */             int _k_ = 0;
/* 792 */             _k_ = _input_.readInt32();
/* 793 */             int readTag = _input_.readTag();
/* 794 */             if (26 != readTag)
/*     */             {
/* 796 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 798 */             xbean.TeamInstance _v_ = xbean.Pod.newTeamInstanceData();
/* 799 */             _input_.readMessage(_v_);
/* 800 */             this.teaminstancemap.put(Integer.valueOf(_k_), _v_);
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
/*     */     public xbean.InstanceBean copy()
/*     */     {
/* 828 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InstanceBean toData()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.InstanceBean toBean()
/*     */     {
/* 839 */       return new InstanceBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InstanceBean toDataIf()
/*     */     {
/* 845 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.InstanceBean toBeanIf()
/*     */     {
/* 850 */       return new InstanceBean(this, null, null);
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
/*     */     public Map<Integer, xbean.SingleInstance> getSingleinstancemap()
/*     */     {
/* 887 */       return this.singleinstancemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SingleInstance> getSingleinstancemapAsData()
/*     */     {
/* 894 */       return this.singleinstancemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSinglefailtime()
/*     */     {
/* 901 */       return this.singlefailtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TeamInstance> getTeaminstancemap()
/*     */     {
/* 908 */       return this.teaminstancemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TeamInstance> getTeaminstancemapAsData()
/*     */     {
/* 915 */       return this.teaminstancemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSinglefailtime(int _v_)
/*     */     {
/* 922 */       this.singlefailtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 928 */       if (!(_o1_ instanceof Data)) return false;
/* 929 */       Data _o_ = (Data)_o1_;
/* 930 */       if (!this.singleinstancemap.equals(_o_.singleinstancemap)) return false;
/* 931 */       if (this.singlefailtime != _o_.singlefailtime) return false;
/* 932 */       if (!this.teaminstancemap.equals(_o_.teaminstancemap)) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.singleinstancemap.hashCode();
/* 941 */       _h_ += this.singlefailtime;
/* 942 */       _h_ += this.teaminstancemap.hashCode();
/* 943 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 949 */       StringBuilder _sb_ = new StringBuilder();
/* 950 */       _sb_.append("(");
/* 951 */       _sb_.append(this.singleinstancemap);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.singlefailtime);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.teaminstancemap);
/* 956 */       _sb_.append(")");
/* 957 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\InstanceBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */