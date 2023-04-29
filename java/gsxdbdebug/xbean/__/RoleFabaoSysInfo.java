/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class RoleFabaoSysInfo extends XBean implements xbean.RoleFabaoSysInfo
/*      */ {
/*      */   private HashMap<Integer, xbean.Item> fabaomap;
/*      */   private HashMap<Integer, xbean.LongJing> longjingmap;
/*      */   private int disfabaotype;
/*      */   private int transfercount;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.fabaomap.clear();
/*   25 */     this.longjingmap.clear();
/*   26 */     this.disfabaotype = 0;
/*   27 */     this.transfercount = -1;
/*      */   }
/*      */   
/*      */   RoleFabaoSysInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.fabaomap = new HashMap();
/*   34 */     this.longjingmap = new HashMap();
/*   35 */     this.transfercount = -1;
/*      */   }
/*      */   
/*      */   public RoleFabaoSysInfo()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleFabaoSysInfo(RoleFabaoSysInfo _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleFabaoSysInfo(xbean.RoleFabaoSysInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof RoleFabaoSysInfo)) { assign((RoleFabaoSysInfo)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleFabaoSysInfo _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.fabaomap = new HashMap();
/*   61 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.fabaomap.entrySet())
/*   62 */       this.fabaomap.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "fabaomap"));
/*   63 */     this.longjingmap = new HashMap();
/*   64 */     for (Map.Entry<Integer, xbean.LongJing> _e_ : _o_.longjingmap.entrySet())
/*   65 */       this.longjingmap.put(_e_.getKey(), new LongJing((xbean.LongJing)_e_.getValue(), this, "longjingmap"));
/*   66 */     this.disfabaotype = _o_.disfabaotype;
/*   67 */     this.transfercount = _o_.transfercount;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   72 */     this.fabaomap = new HashMap();
/*   73 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.fabaomap.entrySet())
/*   74 */       this.fabaomap.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "fabaomap"));
/*   75 */     this.longjingmap = new HashMap();
/*   76 */     for (Map.Entry<Integer, xbean.LongJing> _e_ : _o_.longjingmap.entrySet())
/*   77 */       this.longjingmap.put(_e_.getKey(), new LongJing((xbean.LongJing)_e_.getValue(), this, "longjingmap"));
/*   78 */     this.disfabaotype = _o_.disfabaotype;
/*   79 */     this.transfercount = _o_.transfercount;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.compact_uint32(this.fabaomap.size());
/*   87 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.fabaomap.entrySet())
/*      */     {
/*   89 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   90 */       ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */     }
/*   92 */     _os_.compact_uint32(this.longjingmap.size());
/*   93 */     for (Map.Entry<Integer, xbean.LongJing> _e_ : this.longjingmap.entrySet())
/*      */     {
/*   95 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   96 */       ((xbean.LongJing)_e_.getValue()).marshal(_os_);
/*      */     }
/*   98 */     _os_.marshal(this.disfabaotype);
/*   99 */     _os_.marshal(this.transfercount);
/*  100 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*      */     
/*  108 */     int size = _os_.uncompact_uint32();
/*  109 */     if (size >= 12)
/*      */     {
/*  111 */       this.fabaomap = new HashMap(size * 2);
/*      */     }
/*  113 */     for (; size > 0; size--)
/*      */     {
/*  115 */       int _k_ = 0;
/*  116 */       _k_ = _os_.unmarshal_int();
/*  117 */       xbean.Item _v_ = new Item(0, this, "fabaomap");
/*  118 */       _v_.unmarshal(_os_);
/*  119 */       this.fabaomap.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  123 */     int size = _os_.uncompact_uint32();
/*  124 */     if (size >= 12)
/*      */     {
/*  126 */       this.longjingmap = new HashMap(size * 2);
/*      */     }
/*  128 */     for (; size > 0; size--)
/*      */     {
/*  130 */       int _k_ = 0;
/*  131 */       _k_ = _os_.unmarshal_int();
/*  132 */       xbean.LongJing _v_ = new LongJing(0, this, "longjingmap");
/*  133 */       _v_.unmarshal(_os_);
/*  134 */       this.longjingmap.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  137 */     this.disfabaotype = _os_.unmarshal_int();
/*  138 */     this.transfercount = _os_.unmarshal_int();
/*  139 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  145 */     _xdb_verify_unsafe_();
/*  146 */     int _size_ = 0;
/*  147 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.fabaomap.entrySet())
/*      */     {
/*  149 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  150 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  152 */     for (Map.Entry<Integer, xbean.LongJing> _e_ : this.longjingmap.entrySet())
/*      */     {
/*  154 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  155 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */     }
/*  157 */     _size_ += CodedOutputStream.computeInt32Size(3, this.disfabaotype);
/*  158 */     _size_ += CodedOutputStream.computeInt32Size(4, this.transfercount);
/*  159 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  165 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  168 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.fabaomap.entrySet())
/*      */       {
/*  170 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  171 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  173 */       for (Map.Entry<Integer, xbean.LongJing> _e_ : this.longjingmap.entrySet())
/*      */       {
/*  175 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  176 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*      */       }
/*  178 */       _output_.writeInt32(3, this.disfabaotype);
/*  179 */       _output_.writeInt32(4, this.transfercount);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  183 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  185 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  191 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  194 */       boolean done = false;
/*  195 */       while (!done)
/*      */       {
/*  197 */         int tag = _input_.readTag();
/*  198 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  202 */           done = true;
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  207 */           int _k_ = 0;
/*  208 */           _k_ = _input_.readInt32();
/*  209 */           int readTag = _input_.readTag();
/*  210 */           if (10 != readTag)
/*      */           {
/*  212 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  214 */           xbean.Item _v_ = new Item(0, this, "fabaomap");
/*  215 */           _input_.readMessage(_v_);
/*  216 */           this.fabaomap.put(Integer.valueOf(_k_), _v_);
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  221 */           int _k_ = 0;
/*  222 */           _k_ = _input_.readInt32();
/*  223 */           int readTag = _input_.readTag();
/*  224 */           if (18 != readTag)
/*      */           {
/*  226 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  228 */           xbean.LongJing _v_ = new LongJing(0, this, "longjingmap");
/*  229 */           _input_.readMessage(_v_);
/*  230 */           this.longjingmap.put(Integer.valueOf(_k_), _v_);
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  235 */           this.disfabaotype = _input_.readInt32();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  240 */           this.transfercount = _input_.readInt32();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  245 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  247 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  256 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  260 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  262 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleFabaoSysInfo copy()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new RoleFabaoSysInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleFabaoSysInfo toData()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleFabaoSysInfo toBean()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new RoleFabaoSysInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleFabaoSysInfo toDataIf()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleFabaoSysInfo toBeanIf()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Item> getFabaomap()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return xdb.Logs.logMap(new LogKey(this, "fabaomap"), this.fabaomap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Item> getFabaomapAsData()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*      */     
/*  319 */     RoleFabaoSysInfo _o_ = this;
/*  320 */     Map<Integer, xbean.Item> fabaomap = new HashMap();
/*  321 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.fabaomap.entrySet())
/*  322 */       fabaomap.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  323 */     return fabaomap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.LongJing> getLongjingmap()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return xdb.Logs.logMap(new LogKey(this, "longjingmap"), this.longjingmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.LongJing> getLongjingmapAsData()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*      */     
/*  340 */     RoleFabaoSysInfo _o_ = this;
/*  341 */     Map<Integer, xbean.LongJing> longjingmap = new HashMap();
/*  342 */     for (Map.Entry<Integer, xbean.LongJing> _e_ : _o_.longjingmap.entrySet())
/*  343 */       longjingmap.put(_e_.getKey(), new LongJing.Data((xbean.LongJing)_e_.getValue()));
/*  344 */     return longjingmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDisfabaotype()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return this.disfabaotype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTransfercount()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     return this.transfercount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDisfabaotype(int _v_)
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     xdb.Logs.logIf(new LogKey(this, "disfabaotype")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  372 */         new xdb.logs.LogInt(this, RoleFabaoSysInfo.this.disfabaotype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  376 */             RoleFabaoSysInfo.this.disfabaotype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  380 */     });
/*  381 */     this.disfabaotype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTransfercount(int _v_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     xdb.Logs.logIf(new LogKey(this, "transfercount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  393 */         new xdb.logs.LogInt(this, RoleFabaoSysInfo.this.transfercount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             RoleFabaoSysInfo.this.transfercount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.transfercount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     RoleFabaoSysInfo _o_ = null;
/*  410 */     if ((_o1_ instanceof RoleFabaoSysInfo)) { _o_ = (RoleFabaoSysInfo)_o1_;
/*  411 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  412 */       return false;
/*  413 */     if (!this.fabaomap.equals(_o_.fabaomap)) return false;
/*  414 */     if (!this.longjingmap.equals(_o_.longjingmap)) return false;
/*  415 */     if (this.disfabaotype != _o_.disfabaotype) return false;
/*  416 */     if (this.transfercount != _o_.transfercount) return false;
/*  417 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*  424 */     int _h_ = 0;
/*  425 */     _h_ += this.fabaomap.hashCode();
/*  426 */     _h_ += this.longjingmap.hashCode();
/*  427 */     _h_ += this.disfabaotype;
/*  428 */     _h_ += this.transfercount;
/*  429 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     StringBuilder _sb_ = new StringBuilder();
/*  437 */     _sb_.append("(");
/*  438 */     _sb_.append(this.fabaomap);
/*  439 */     _sb_.append(",");
/*  440 */     _sb_.append(this.longjingmap);
/*  441 */     _sb_.append(",");
/*  442 */     _sb_.append(this.disfabaotype);
/*  443 */     _sb_.append(",");
/*  444 */     _sb_.append(this.transfercount);
/*  445 */     _sb_.append(")");
/*  446 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  452 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  453 */     lb.add(new xdb.logs.ListenableMap().setVarName("fabaomap"));
/*  454 */     lb.add(new xdb.logs.ListenableMap().setVarName("longjingmap"));
/*  455 */     lb.add(new xdb.logs.ListenableChanged().setVarName("disfabaotype"));
/*  456 */     lb.add(new xdb.logs.ListenableChanged().setVarName("transfercount"));
/*  457 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleFabaoSysInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoleFabaoSysInfo nThis() {
/*  464 */       return RoleFabaoSysInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  470 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFabaoSysInfo copy()
/*      */     {
/*  476 */       return RoleFabaoSysInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFabaoSysInfo toData()
/*      */     {
/*  482 */       return RoleFabaoSysInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleFabaoSysInfo toBean()
/*      */     {
/*  487 */       return RoleFabaoSysInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFabaoSysInfo toDataIf()
/*      */     {
/*  493 */       return RoleFabaoSysInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleFabaoSysInfo toBeanIf()
/*      */     {
/*  498 */       return RoleFabaoSysInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getFabaomap()
/*      */     {
/*  505 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  506 */       return xdb.Consts.constMap(RoleFabaoSysInfo.this.fabaomap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getFabaomapAsData()
/*      */     {
/*  513 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*      */       
/*  515 */       RoleFabaoSysInfo _o_ = RoleFabaoSysInfo.this;
/*  516 */       Map<Integer, xbean.Item> fabaomap = new HashMap();
/*  517 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.fabaomap.entrySet())
/*  518 */         fabaomap.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  519 */       return fabaomap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LongJing> getLongjingmap()
/*      */     {
/*  526 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  527 */       return xdb.Consts.constMap(RoleFabaoSysInfo.this.longjingmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LongJing> getLongjingmapAsData()
/*      */     {
/*  534 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*      */       
/*  536 */       RoleFabaoSysInfo _o_ = RoleFabaoSysInfo.this;
/*  537 */       Map<Integer, xbean.LongJing> longjingmap = new HashMap();
/*  538 */       for (Map.Entry<Integer, xbean.LongJing> _e_ : _o_.longjingmap.entrySet())
/*  539 */         longjingmap.put(_e_.getKey(), new LongJing.Data((xbean.LongJing)_e_.getValue()));
/*  540 */       return longjingmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDisfabaotype()
/*      */     {
/*  547 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  548 */       return RoleFabaoSysInfo.this.disfabaotype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTransfercount()
/*      */     {
/*  555 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  556 */       return RoleFabaoSysInfo.this.transfercount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDisfabaotype(int _v_)
/*      */     {
/*  563 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  564 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTransfercount(int _v_)
/*      */     {
/*  571 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  572 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  578 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  579 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  585 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  586 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  592 */       return RoleFabaoSysInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  598 */       return RoleFabaoSysInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  604 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  611 */       return RoleFabaoSysInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  617 */       return RoleFabaoSysInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  623 */       RoleFabaoSysInfo.this._xdb_verify_unsafe_();
/*  624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  630 */       return RoleFabaoSysInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  636 */       return RoleFabaoSysInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  642 */       return RoleFabaoSysInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  648 */       return RoleFabaoSysInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  654 */       return RoleFabaoSysInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  660 */       return RoleFabaoSysInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  666 */       return RoleFabaoSysInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleFabaoSysInfo
/*      */   {
/*      */     private HashMap<Integer, xbean.Item> fabaomap;
/*      */     
/*      */     private HashMap<Integer, xbean.LongJing> longjingmap;
/*      */     
/*      */     private int disfabaotype;
/*      */     
/*      */     private int transfercount;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  689 */       this.fabaomap = new HashMap();
/*  690 */       this.longjingmap = new HashMap();
/*  691 */       this.transfercount = -1;
/*      */     }
/*      */     
/*      */     Data(xbean.RoleFabaoSysInfo _o1_)
/*      */     {
/*  696 */       if ((_o1_ instanceof RoleFabaoSysInfo)) { assign((RoleFabaoSysInfo)_o1_);
/*  697 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  698 */       } else if ((_o1_ instanceof RoleFabaoSysInfo.Const)) assign(((RoleFabaoSysInfo.Const)_o1_).nThis()); else {
/*  699 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleFabaoSysInfo _o_) {
/*  704 */       this.fabaomap = new HashMap();
/*  705 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.fabaomap.entrySet())
/*  706 */         this.fabaomap.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  707 */       this.longjingmap = new HashMap();
/*  708 */       for (Map.Entry<Integer, xbean.LongJing> _e_ : _o_.longjingmap.entrySet())
/*  709 */         this.longjingmap.put(_e_.getKey(), new LongJing.Data((xbean.LongJing)_e_.getValue()));
/*  710 */       this.disfabaotype = _o_.disfabaotype;
/*  711 */       this.transfercount = _o_.transfercount;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  716 */       this.fabaomap = new HashMap();
/*  717 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.fabaomap.entrySet())
/*  718 */         this.fabaomap.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  719 */       this.longjingmap = new HashMap();
/*  720 */       for (Map.Entry<Integer, xbean.LongJing> _e_ : _o_.longjingmap.entrySet())
/*  721 */         this.longjingmap.put(_e_.getKey(), new LongJing.Data((xbean.LongJing)_e_.getValue()));
/*  722 */       this.disfabaotype = _o_.disfabaotype;
/*  723 */       this.transfercount = _o_.transfercount;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  729 */       _os_.compact_uint32(this.fabaomap.size());
/*  730 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.fabaomap.entrySet())
/*      */       {
/*  732 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  733 */         ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */       }
/*  735 */       _os_.compact_uint32(this.longjingmap.size());
/*  736 */       for (Map.Entry<Integer, xbean.LongJing> _e_ : this.longjingmap.entrySet())
/*      */       {
/*  738 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  739 */         ((xbean.LongJing)_e_.getValue()).marshal(_os_);
/*      */       }
/*  741 */       _os_.marshal(this.disfabaotype);
/*  742 */       _os_.marshal(this.transfercount);
/*  743 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  750 */       int size = _os_.uncompact_uint32();
/*  751 */       if (size >= 12)
/*      */       {
/*  753 */         this.fabaomap = new HashMap(size * 2);
/*      */       }
/*  755 */       for (; size > 0; size--)
/*      */       {
/*  757 */         int _k_ = 0;
/*  758 */         _k_ = _os_.unmarshal_int();
/*  759 */         xbean.Item _v_ = xbean.Pod.newItemData();
/*  760 */         _v_.unmarshal(_os_);
/*  761 */         this.fabaomap.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  765 */       int size = _os_.uncompact_uint32();
/*  766 */       if (size >= 12)
/*      */       {
/*  768 */         this.longjingmap = new HashMap(size * 2);
/*      */       }
/*  770 */       for (; size > 0; size--)
/*      */       {
/*  772 */         int _k_ = 0;
/*  773 */         _k_ = _os_.unmarshal_int();
/*  774 */         xbean.LongJing _v_ = xbean.Pod.newLongJingData();
/*  775 */         _v_.unmarshal(_os_);
/*  776 */         this.longjingmap.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  779 */       this.disfabaotype = _os_.unmarshal_int();
/*  780 */       this.transfercount = _os_.unmarshal_int();
/*  781 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  787 */       int _size_ = 0;
/*  788 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.fabaomap.entrySet())
/*      */       {
/*  790 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  791 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/*  793 */       for (Map.Entry<Integer, xbean.LongJing> _e_ : this.longjingmap.entrySet())
/*      */       {
/*  795 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  796 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */       }
/*  798 */       _size_ += CodedOutputStream.computeInt32Size(3, this.disfabaotype);
/*  799 */       _size_ += CodedOutputStream.computeInt32Size(4, this.transfercount);
/*  800 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  808 */         for (Map.Entry<Integer, xbean.Item> _e_ : this.fabaomap.entrySet())
/*      */         {
/*  810 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  811 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/*  813 */         for (Map.Entry<Integer, xbean.LongJing> _e_ : this.longjingmap.entrySet())
/*      */         {
/*  815 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  816 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*      */         }
/*  818 */         _output_.writeInt32(3, this.disfabaotype);
/*  819 */         _output_.writeInt32(4, this.transfercount);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  823 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  825 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  833 */         boolean done = false;
/*  834 */         while (!done)
/*      */         {
/*  836 */           int tag = _input_.readTag();
/*  837 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  841 */             done = true;
/*  842 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  846 */             int _k_ = 0;
/*  847 */             _k_ = _input_.readInt32();
/*  848 */             int readTag = _input_.readTag();
/*  849 */             if (10 != readTag)
/*      */             {
/*  851 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  853 */             xbean.Item _v_ = xbean.Pod.newItemData();
/*  854 */             _input_.readMessage(_v_);
/*  855 */             this.fabaomap.put(Integer.valueOf(_k_), _v_);
/*  856 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  860 */             int _k_ = 0;
/*  861 */             _k_ = _input_.readInt32();
/*  862 */             int readTag = _input_.readTag();
/*  863 */             if (18 != readTag)
/*      */             {
/*  865 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  867 */             xbean.LongJing _v_ = xbean.Pod.newLongJingData();
/*  868 */             _input_.readMessage(_v_);
/*  869 */             this.longjingmap.put(Integer.valueOf(_k_), _v_);
/*  870 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  874 */             this.disfabaotype = _input_.readInt32();
/*  875 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  879 */             this.transfercount = _input_.readInt32();
/*  880 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  884 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  886 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  895 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  899 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  901 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFabaoSysInfo copy()
/*      */     {
/*  907 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFabaoSysInfo toData()
/*      */     {
/*  913 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleFabaoSysInfo toBean()
/*      */     {
/*  918 */       return new RoleFabaoSysInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFabaoSysInfo toDataIf()
/*      */     {
/*  924 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleFabaoSysInfo toBeanIf()
/*      */     {
/*  929 */       return new RoleFabaoSysInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  955 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  959 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getFabaomap()
/*      */     {
/*  966 */       return this.fabaomap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getFabaomapAsData()
/*      */     {
/*  973 */       return this.fabaomap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LongJing> getLongjingmap()
/*      */     {
/*  980 */       return this.longjingmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LongJing> getLongjingmapAsData()
/*      */     {
/*  987 */       return this.longjingmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDisfabaotype()
/*      */     {
/*  994 */       return this.disfabaotype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTransfercount()
/*      */     {
/* 1001 */       return this.transfercount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDisfabaotype(int _v_)
/*      */     {
/* 1008 */       this.disfabaotype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTransfercount(int _v_)
/*      */     {
/* 1015 */       this.transfercount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1021 */       if (!(_o1_ instanceof Data)) return false;
/* 1022 */       Data _o_ = (Data)_o1_;
/* 1023 */       if (!this.fabaomap.equals(_o_.fabaomap)) return false;
/* 1024 */       if (!this.longjingmap.equals(_o_.longjingmap)) return false;
/* 1025 */       if (this.disfabaotype != _o_.disfabaotype) return false;
/* 1026 */       if (this.transfercount != _o_.transfercount) return false;
/* 1027 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1033 */       int _h_ = 0;
/* 1034 */       _h_ += this.fabaomap.hashCode();
/* 1035 */       _h_ += this.longjingmap.hashCode();
/* 1036 */       _h_ += this.disfabaotype;
/* 1037 */       _h_ += this.transfercount;
/* 1038 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1044 */       StringBuilder _sb_ = new StringBuilder();
/* 1045 */       _sb_.append("(");
/* 1046 */       _sb_.append(this.fabaomap);
/* 1047 */       _sb_.append(",");
/* 1048 */       _sb_.append(this.longjingmap);
/* 1049 */       _sb_.append(",");
/* 1050 */       _sb_.append(this.disfabaotype);
/* 1051 */       _sb_.append(",");
/* 1052 */       _sb_.append(this.transfercount);
/* 1053 */       _sb_.append(")");
/* 1054 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleFabaoSysInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */