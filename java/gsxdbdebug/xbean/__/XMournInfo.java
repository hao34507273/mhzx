/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ 
/*     */ public final class XMournInfo extends xdb.XBean implements xbean.XMournInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.XMTaskInfo> mourndatas;
/*     */   private xbean.XMTaskInfo lastmourndata;
/*     */   private ArrayList<Integer> sort;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.mourndatas.clear();
/*  23 */     this.lastmourndata._reset_unsafe_();
/*  24 */     this.sort.clear();
/*     */   }
/*     */   
/*     */   XMournInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.mourndatas = new HashMap();
/*  31 */     this.lastmourndata = new XMTaskInfo(0, this, "lastmourndata");
/*  32 */     this.sort = new ArrayList();
/*     */   }
/*     */   
/*     */   public XMournInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public XMournInfo(XMournInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   XMournInfo(xbean.XMournInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof XMournInfo)) { assign((XMournInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(XMournInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.mourndatas = new HashMap();
/*  58 */     for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : _o_.mourndatas.entrySet())
/*  59 */       this.mourndatas.put(_e_.getKey(), new XMTaskInfo((xbean.XMTaskInfo)_e_.getValue(), this, "mourndatas"));
/*  60 */     this.lastmourndata = new XMTaskInfo(_o_.lastmourndata, this, "lastmourndata");
/*  61 */     this.sort = new ArrayList();
/*  62 */     this.sort.addAll(_o_.sort);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.mourndatas = new HashMap();
/*  68 */     for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : _o_.mourndatas.entrySet())
/*  69 */       this.mourndatas.put(_e_.getKey(), new XMTaskInfo((xbean.XMTaskInfo)_e_.getValue(), this, "mourndatas"));
/*  70 */     this.lastmourndata = new XMTaskInfo(_o_.lastmourndata, this, "lastmourndata");
/*  71 */     this.sort = new ArrayList();
/*  72 */     this.sort.addAll(_o_.sort);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.compact_uint32(this.mourndatas.size());
/*  80 */     for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : this.mourndatas.entrySet())
/*     */     {
/*  82 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  83 */       ((xbean.XMTaskInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  85 */     this.lastmourndata.marshal(_os_);
/*  86 */     _os_.compact_uint32(this.sort.size());
/*  87 */     for (Integer _v_ : this.sort)
/*     */     {
/*  89 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*     */     
/*  99 */     int size = _os_.uncompact_uint32();
/* 100 */     if (size >= 12)
/*     */     {
/* 102 */       this.mourndatas = new HashMap(size * 2);
/*     */     }
/* 104 */     for (; size > 0; size--)
/*     */     {
/* 106 */       int _k_ = 0;
/* 107 */       _k_ = _os_.unmarshal_int();
/* 108 */       xbean.XMTaskInfo _v_ = new XMTaskInfo(0, this, "mourndatas");
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.mourndatas.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 113 */     this.lastmourndata.unmarshal(_os_);
/* 114 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 116 */       int _v_ = 0;
/* 117 */       _v_ = _os_.unmarshal_int();
/* 118 */       this.sort.add(Integer.valueOf(_v_));
/*     */     }
/* 120 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/* 127 */     int _size_ = 0;
/* 128 */     for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : this.mourndatas.entrySet())
/*     */     {
/* 130 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 131 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 133 */     _size_ += CodedOutputStream.computeMessageSize(2, this.lastmourndata);
/* 134 */     for (Integer _v_ : this.sort)
/*     */     {
/* 136 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 138 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 147 */       for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : this.mourndatas.entrySet())
/*     */       {
/* 149 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 150 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 152 */       _output_.writeMessage(2, this.lastmourndata);
/* 153 */       for (Integer _v_ : this.sort)
/*     */       {
/* 155 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 160 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 162 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 168 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 171 */       boolean done = false;
/* 172 */       while (!done)
/*     */       {
/* 174 */         int tag = _input_.readTag();
/* 175 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 179 */           done = true;
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 184 */           int _k_ = 0;
/* 185 */           _k_ = _input_.readInt32();
/* 186 */           int readTag = _input_.readTag();
/* 187 */           if (10 != readTag)
/*     */           {
/* 189 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 191 */           xbean.XMTaskInfo _v_ = new XMTaskInfo(0, this, "mourndatas");
/* 192 */           _input_.readMessage(_v_);
/* 193 */           this.mourndatas.put(Integer.valueOf(_k_), _v_);
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 198 */           _input_.readMessage(this.lastmourndata);
/* 199 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 203 */           int _v_ = 0;
/* 204 */           _v_ = _input_.readInt32();
/* 205 */           this.sort.add(Integer.valueOf(_v_));
/* 206 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 210 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 212 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 221 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 225 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 227 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XMournInfo copy()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new XMournInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XMournInfo toData()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XMournInfo toBean()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new XMournInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XMournInfo toDataIf()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XMournInfo toBeanIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.XMTaskInfo> getMourndatas()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return xdb.Logs.logMap(new xdb.LogKey(this, "mourndatas"), this.mourndatas);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.XMTaskInfo> getMourndatasAsData()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/*     */     
/* 284 */     XMournInfo _o_ = this;
/* 285 */     Map<Integer, xbean.XMTaskInfo> mourndatas = new HashMap();
/* 286 */     for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : _o_.mourndatas.entrySet())
/* 287 */       mourndatas.put(_e_.getKey(), new XMTaskInfo.Data((xbean.XMTaskInfo)_e_.getValue()));
/* 288 */     return mourndatas;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.XMTaskInfo getLastmourndata()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return this.lastmourndata;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getSort()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     return xdb.Logs.logList(new xdb.LogKey(this, "sort"), this.sort);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getSortAsData()
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/*     */     
/* 312 */     XMournInfo _o_ = this;
/* 313 */     List<Integer> sort = new ArrayList();
/* 314 */     sort.addAll(_o_.sort);
/* 315 */     return sort;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     XMournInfo _o_ = null;
/* 323 */     if ((_o1_ instanceof XMournInfo)) { _o_ = (XMournInfo)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.mourndatas.equals(_o_.mourndatas)) return false;
/* 327 */     if (!this.lastmourndata.equals(_o_.lastmourndata)) return false;
/* 328 */     if (!this.sort.equals(_o_.sort)) return false;
/* 329 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     int _h_ = 0;
/* 337 */     _h_ += this.mourndatas.hashCode();
/* 338 */     _h_ += this.lastmourndata.hashCode();
/* 339 */     _h_ += this.sort.hashCode();
/* 340 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 346 */     _xdb_verify_unsafe_();
/* 347 */     StringBuilder _sb_ = new StringBuilder();
/* 348 */     _sb_.append("(");
/* 349 */     _sb_.append(this.mourndatas);
/* 350 */     _sb_.append(",");
/* 351 */     _sb_.append(this.lastmourndata);
/* 352 */     _sb_.append(",");
/* 353 */     _sb_.append(this.sort);
/* 354 */     _sb_.append(")");
/* 355 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 361 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 362 */     lb.add(new xdb.logs.ListenableMap().setVarName("mourndatas"));
/* 363 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastmourndata"));
/* 364 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sort"));
/* 365 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.XMournInfo {
/*     */     private Const() {}
/*     */     
/*     */     XMournInfo nThis() {
/* 372 */       return XMournInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 378 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XMournInfo copy()
/*     */     {
/* 384 */       return XMournInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XMournInfo toData()
/*     */     {
/* 390 */       return XMournInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.XMournInfo toBean()
/*     */     {
/* 395 */       return XMournInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XMournInfo toDataIf()
/*     */     {
/* 401 */       return XMournInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.XMournInfo toBeanIf()
/*     */     {
/* 406 */       return XMournInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XMTaskInfo> getMourndatas()
/*     */     {
/* 413 */       XMournInfo.this._xdb_verify_unsafe_();
/* 414 */       return xdb.Consts.constMap(XMournInfo.this.mourndatas);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XMTaskInfo> getMourndatasAsData()
/*     */     {
/* 421 */       XMournInfo.this._xdb_verify_unsafe_();
/*     */       
/* 423 */       XMournInfo _o_ = XMournInfo.this;
/* 424 */       Map<Integer, xbean.XMTaskInfo> mourndatas = new HashMap();
/* 425 */       for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : _o_.mourndatas.entrySet())
/* 426 */         mourndatas.put(_e_.getKey(), new XMTaskInfo.Data((xbean.XMTaskInfo)_e_.getValue()));
/* 427 */       return mourndatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.XMTaskInfo getLastmourndata()
/*     */     {
/* 434 */       XMournInfo.this._xdb_verify_unsafe_();
/* 435 */       return (xbean.XMTaskInfo)xdb.Consts.toConst(XMournInfo.this.lastmourndata);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getSort()
/*     */     {
/* 442 */       XMournInfo.this._xdb_verify_unsafe_();
/* 443 */       return xdb.Consts.constList(XMournInfo.this.sort);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getSortAsData()
/*     */     {
/* 449 */       XMournInfo.this._xdb_verify_unsafe_();
/*     */       
/* 451 */       XMournInfo _o_ = XMournInfo.this;
/* 452 */       List<Integer> sort = new ArrayList();
/* 453 */       sort.addAll(_o_.sort);
/* 454 */       return sort;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 460 */       XMournInfo.this._xdb_verify_unsafe_();
/* 461 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 467 */       XMournInfo.this._xdb_verify_unsafe_();
/* 468 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 474 */       return XMournInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 480 */       return XMournInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 486 */       XMournInfo.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 493 */       return XMournInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 499 */       return XMournInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 505 */       XMournInfo.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 512 */       return XMournInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 518 */       return XMournInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 524 */       return XMournInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 530 */       return XMournInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 536 */       return XMournInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 542 */       return XMournInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 548 */       return XMournInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.XMournInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.XMTaskInfo> mourndatas;
/*     */     
/*     */     private xbean.XMTaskInfo lastmourndata;
/*     */     
/*     */     private ArrayList<Integer> sort;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 569 */       this.mourndatas = new HashMap();
/* 570 */       this.lastmourndata = new XMTaskInfo.Data();
/* 571 */       this.sort = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.XMournInfo _o1_)
/*     */     {
/* 576 */       if ((_o1_ instanceof XMournInfo)) { assign((XMournInfo)_o1_);
/* 577 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 578 */       } else if ((_o1_ instanceof XMournInfo.Const)) assign(((XMournInfo.Const)_o1_).nThis()); else {
/* 579 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(XMournInfo _o_) {
/* 584 */       this.mourndatas = new HashMap();
/* 585 */       for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : _o_.mourndatas.entrySet())
/* 586 */         this.mourndatas.put(_e_.getKey(), new XMTaskInfo.Data((xbean.XMTaskInfo)_e_.getValue()));
/* 587 */       this.lastmourndata = new XMTaskInfo.Data(_o_.lastmourndata);
/* 588 */       this.sort = new ArrayList();
/* 589 */       this.sort.addAll(_o_.sort);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 594 */       this.mourndatas = new HashMap();
/* 595 */       for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : _o_.mourndatas.entrySet())
/* 596 */         this.mourndatas.put(_e_.getKey(), new XMTaskInfo.Data((xbean.XMTaskInfo)_e_.getValue()));
/* 597 */       this.lastmourndata = new XMTaskInfo.Data(_o_.lastmourndata);
/* 598 */       this.sort = new ArrayList();
/* 599 */       this.sort.addAll(_o_.sort);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 605 */       _os_.compact_uint32(this.mourndatas.size());
/* 606 */       for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : this.mourndatas.entrySet())
/*     */       {
/* 608 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 609 */         ((xbean.XMTaskInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 611 */       this.lastmourndata.marshal(_os_);
/* 612 */       _os_.compact_uint32(this.sort.size());
/* 613 */       for (Integer _v_ : this.sort)
/*     */       {
/* 615 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 617 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 624 */       int size = _os_.uncompact_uint32();
/* 625 */       if (size >= 12)
/*     */       {
/* 627 */         this.mourndatas = new HashMap(size * 2);
/*     */       }
/* 629 */       for (; size > 0; size--)
/*     */       {
/* 631 */         int _k_ = 0;
/* 632 */         _k_ = _os_.unmarshal_int();
/* 633 */         xbean.XMTaskInfo _v_ = xbean.Pod.newXMTaskInfoData();
/* 634 */         _v_.unmarshal(_os_);
/* 635 */         this.mourndatas.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 638 */       this.lastmourndata.unmarshal(_os_);
/* 639 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 641 */         int _v_ = 0;
/* 642 */         _v_ = _os_.unmarshal_int();
/* 643 */         this.sort.add(Integer.valueOf(_v_));
/*     */       }
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 651 */       int _size_ = 0;
/* 652 */       for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : this.mourndatas.entrySet())
/*     */       {
/* 654 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 655 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 657 */       _size_ += CodedOutputStream.computeMessageSize(2, this.lastmourndata);
/* 658 */       for (Integer _v_ : this.sort)
/*     */       {
/* 660 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 662 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 670 */         for (Map.Entry<Integer, xbean.XMTaskInfo> _e_ : this.mourndatas.entrySet())
/*     */         {
/* 672 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 673 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 675 */         _output_.writeMessage(2, this.lastmourndata);
/* 676 */         for (Integer _v_ : this.sort)
/*     */         {
/* 678 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 683 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 685 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 693 */         boolean done = false;
/* 694 */         while (!done)
/*     */         {
/* 696 */           int tag = _input_.readTag();
/* 697 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 701 */             done = true;
/* 702 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 706 */             int _k_ = 0;
/* 707 */             _k_ = _input_.readInt32();
/* 708 */             int readTag = _input_.readTag();
/* 709 */             if (10 != readTag)
/*     */             {
/* 711 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 713 */             xbean.XMTaskInfo _v_ = xbean.Pod.newXMTaskInfoData();
/* 714 */             _input_.readMessage(_v_);
/* 715 */             this.mourndatas.put(Integer.valueOf(_k_), _v_);
/* 716 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 720 */             _input_.readMessage(this.lastmourndata);
/* 721 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 725 */             int _v_ = 0;
/* 726 */             _v_ = _input_.readInt32();
/* 727 */             this.sort.add(Integer.valueOf(_v_));
/* 728 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 732 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 734 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 743 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 747 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 749 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XMournInfo copy()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XMournInfo toData()
/*     */     {
/* 761 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.XMournInfo toBean()
/*     */     {
/* 766 */       return new XMournInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XMournInfo toDataIf()
/*     */     {
/* 772 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.XMournInfo toBeanIf()
/*     */     {
/* 777 */       return new XMournInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 799 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 803 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 807 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XMTaskInfo> getMourndatas()
/*     */     {
/* 814 */       return this.mourndatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.XMTaskInfo> getMourndatasAsData()
/*     */     {
/* 821 */       return this.mourndatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.XMTaskInfo getLastmourndata()
/*     */     {
/* 828 */       return this.lastmourndata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getSort()
/*     */     {
/* 835 */       return this.sort;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getSortAsData()
/*     */     {
/* 842 */       return this.sort;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 848 */       if (!(_o1_ instanceof Data)) return false;
/* 849 */       Data _o_ = (Data)_o1_;
/* 850 */       if (!this.mourndatas.equals(_o_.mourndatas)) return false;
/* 851 */       if (!this.lastmourndata.equals(_o_.lastmourndata)) return false;
/* 852 */       if (!this.sort.equals(_o_.sort)) return false;
/* 853 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 859 */       int _h_ = 0;
/* 860 */       _h_ += this.mourndatas.hashCode();
/* 861 */       _h_ += this.lastmourndata.hashCode();
/* 862 */       _h_ += this.sort.hashCode();
/* 863 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 869 */       StringBuilder _sb_ = new StringBuilder();
/* 870 */       _sb_.append("(");
/* 871 */       _sb_.append(this.mourndatas);
/* 872 */       _sb_.append(",");
/* 873 */       _sb_.append(this.lastmourndata);
/* 874 */       _sb_.append(",");
/* 875 */       _sb_.append(this.sort);
/* 876 */       _sb_.append(")");
/* 877 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\XMournInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */