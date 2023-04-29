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
/*      */ public final class CustommizedCons extends XBean implements xbean.CustommizedCons
/*      */ {
/*      */   private long lastsearchtime;
/*      */   private HashMap<Integer, xbean.MarketEquipConSet> subid2equipcons;
/*      */   private HashMap<Integer, xbean.MarketPetConSet> subid2petcons;
/*      */   private HashMap<Integer, xbean.MarketPetEquipConSet> subid2petequipcons;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.lastsearchtime = 0L;
/*   25 */     this.subid2equipcons.clear();
/*   26 */     this.subid2petcons.clear();
/*   27 */     this.subid2petequipcons.clear();
/*      */   }
/*      */   
/*      */   CustommizedCons(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.subid2equipcons = new HashMap();
/*   34 */     this.subid2petcons = new HashMap();
/*   35 */     this.subid2petequipcons = new HashMap();
/*      */   }
/*      */   
/*      */   public CustommizedCons()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CustommizedCons(CustommizedCons _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CustommizedCons(xbean.CustommizedCons _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof CustommizedCons)) { assign((CustommizedCons)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CustommizedCons _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.lastsearchtime = _o_.lastsearchtime;
/*   61 */     this.subid2equipcons = new HashMap();
/*   62 */     for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : _o_.subid2equipcons.entrySet())
/*   63 */       this.subid2equipcons.put(_e_.getKey(), new MarketEquipConSet((xbean.MarketEquipConSet)_e_.getValue(), this, "subid2equipcons"));
/*   64 */     this.subid2petcons = new HashMap();
/*   65 */     for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : _o_.subid2petcons.entrySet())
/*   66 */       this.subid2petcons.put(_e_.getKey(), new MarketPetConSet((xbean.MarketPetConSet)_e_.getValue(), this, "subid2petcons"));
/*   67 */     this.subid2petequipcons = new HashMap();
/*   68 */     for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : _o_.subid2petequipcons.entrySet()) {
/*   69 */       this.subid2petequipcons.put(_e_.getKey(), new MarketPetEquipConSet((xbean.MarketPetEquipConSet)_e_.getValue(), this, "subid2petequipcons"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   74 */     this.lastsearchtime = _o_.lastsearchtime;
/*   75 */     this.subid2equipcons = new HashMap();
/*   76 */     for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : _o_.subid2equipcons.entrySet())
/*   77 */       this.subid2equipcons.put(_e_.getKey(), new MarketEquipConSet((xbean.MarketEquipConSet)_e_.getValue(), this, "subid2equipcons"));
/*   78 */     this.subid2petcons = new HashMap();
/*   79 */     for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : _o_.subid2petcons.entrySet())
/*   80 */       this.subid2petcons.put(_e_.getKey(), new MarketPetConSet((xbean.MarketPetConSet)_e_.getValue(), this, "subid2petcons"));
/*   81 */     this.subid2petequipcons = new HashMap();
/*   82 */     for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : _o_.subid2petequipcons.entrySet()) {
/*   83 */       this.subid2petequipcons.put(_e_.getKey(), new MarketPetEquipConSet((xbean.MarketPetEquipConSet)_e_.getValue(), this, "subid2petequipcons"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.lastsearchtime);
/*   91 */     _os_.compact_uint32(this.subid2equipcons.size());
/*   92 */     for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : this.subid2equipcons.entrySet())
/*      */     {
/*   94 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   95 */       ((xbean.MarketEquipConSet)_e_.getValue()).marshal(_os_);
/*      */     }
/*   97 */     _os_.compact_uint32(this.subid2petcons.size());
/*   98 */     for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : this.subid2petcons.entrySet())
/*      */     {
/*  100 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  101 */       ((xbean.MarketPetConSet)_e_.getValue()).marshal(_os_);
/*      */     }
/*  103 */     _os_.compact_uint32(this.subid2petequipcons.size());
/*  104 */     for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : this.subid2petequipcons.entrySet())
/*      */     {
/*  106 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  107 */       ((xbean.MarketPetEquipConSet)_e_.getValue()).marshal(_os_);
/*      */     }
/*  109 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*  116 */     this.lastsearchtime = _os_.unmarshal_long();
/*      */     
/*  118 */     int size = _os_.uncompact_uint32();
/*  119 */     if (size >= 12)
/*      */     {
/*  121 */       this.subid2equipcons = new HashMap(size * 2);
/*      */     }
/*  123 */     for (; size > 0; size--)
/*      */     {
/*  125 */       int _k_ = 0;
/*  126 */       _k_ = _os_.unmarshal_int();
/*  127 */       xbean.MarketEquipConSet _v_ = new MarketEquipConSet(0, this, "subid2equipcons");
/*  128 */       _v_.unmarshal(_os_);
/*  129 */       this.subid2equipcons.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  133 */     int size = _os_.uncompact_uint32();
/*  134 */     if (size >= 12)
/*      */     {
/*  136 */       this.subid2petcons = new HashMap(size * 2);
/*      */     }
/*  138 */     for (; size > 0; size--)
/*      */     {
/*  140 */       int _k_ = 0;
/*  141 */       _k_ = _os_.unmarshal_int();
/*  142 */       xbean.MarketPetConSet _v_ = new MarketPetConSet(0, this, "subid2petcons");
/*  143 */       _v_.unmarshal(_os_);
/*  144 */       this.subid2petcons.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  148 */     int size = _os_.uncompact_uint32();
/*  149 */     if (size >= 12)
/*      */     {
/*  151 */       this.subid2petequipcons = new HashMap(size * 2);
/*      */     }
/*  153 */     for (; size > 0; size--)
/*      */     {
/*  155 */       int _k_ = 0;
/*  156 */       _k_ = _os_.unmarshal_int();
/*  157 */       xbean.MarketPetEquipConSet _v_ = new MarketPetEquipConSet(0, this, "subid2petequipcons");
/*  158 */       _v_.unmarshal(_os_);
/*  159 */       this.subid2petequipcons.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  162 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  168 */     _xdb_verify_unsafe_();
/*  169 */     int _size_ = 0;
/*  170 */     _size_ += CodedOutputStream.computeInt64Size(1, this.lastsearchtime);
/*  171 */     for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : this.subid2equipcons.entrySet())
/*      */     {
/*  173 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  174 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */     }
/*  176 */     for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : this.subid2petcons.entrySet())
/*      */     {
/*  178 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  179 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  181 */     for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : this.subid2petequipcons.entrySet())
/*      */     {
/*  183 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  184 */       _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */     }
/*  186 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  192 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  195 */       _output_.writeInt64(1, this.lastsearchtime);
/*  196 */       for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : this.subid2equipcons.entrySet())
/*      */       {
/*  198 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  199 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*      */       }
/*  201 */       for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : this.subid2petcons.entrySet())
/*      */       {
/*  203 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  204 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  206 */       for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : this.subid2petequipcons.entrySet())
/*      */       {
/*  208 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  209 */         _output_.writeMessage(4, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  214 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  216 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  225 */       boolean done = false;
/*  226 */       while (!done)
/*      */       {
/*  228 */         int tag = _input_.readTag();
/*  229 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  233 */           done = true;
/*  234 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  238 */           this.lastsearchtime = _input_.readInt64();
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  243 */           int _k_ = 0;
/*  244 */           _k_ = _input_.readInt32();
/*  245 */           int readTag = _input_.readTag();
/*  246 */           if (18 != readTag)
/*      */           {
/*  248 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  250 */           xbean.MarketEquipConSet _v_ = new MarketEquipConSet(0, this, "subid2equipcons");
/*  251 */           _input_.readMessage(_v_);
/*  252 */           this.subid2equipcons.put(Integer.valueOf(_k_), _v_);
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  257 */           int _k_ = 0;
/*  258 */           _k_ = _input_.readInt32();
/*  259 */           int readTag = _input_.readTag();
/*  260 */           if (26 != readTag)
/*      */           {
/*  262 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  264 */           xbean.MarketPetConSet _v_ = new MarketPetConSet(0, this, "subid2petcons");
/*  265 */           _input_.readMessage(_v_);
/*  266 */           this.subid2petcons.put(Integer.valueOf(_k_), _v_);
/*  267 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  271 */           int _k_ = 0;
/*  272 */           _k_ = _input_.readInt32();
/*  273 */           int readTag = _input_.readTag();
/*  274 */           if (34 != readTag)
/*      */           {
/*  276 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  278 */           xbean.MarketPetEquipConSet _v_ = new MarketPetEquipConSet(0, this, "subid2petequipcons");
/*  279 */           _input_.readMessage(_v_);
/*  280 */           this.subid2petequipcons.put(Integer.valueOf(_k_), _v_);
/*  281 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  285 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  287 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  296 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  300 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  302 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CustommizedCons copy()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return new CustommizedCons(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CustommizedCons toData()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CustommizedCons toBean()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return new CustommizedCons(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CustommizedCons toDataIf()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CustommizedCons toBeanIf()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*  342 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastsearchtime()
/*      */   {
/*  349 */     _xdb_verify_unsafe_();
/*  350 */     return this.lastsearchtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MarketEquipConSet> getSubid2equipcons()
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     return xdb.Logs.logMap(new LogKey(this, "subid2equipcons"), this.subid2equipcons);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MarketEquipConSet> getSubid2equipconsAsData()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*      */     
/*  367 */     CustommizedCons _o_ = this;
/*  368 */     Map<Integer, xbean.MarketEquipConSet> subid2equipcons = new HashMap();
/*  369 */     for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : _o_.subid2equipcons.entrySet())
/*  370 */       subid2equipcons.put(_e_.getKey(), new MarketEquipConSet.Data((xbean.MarketEquipConSet)_e_.getValue()));
/*  371 */     return subid2equipcons;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MarketPetConSet> getSubid2petcons()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return xdb.Logs.logMap(new LogKey(this, "subid2petcons"), this.subid2petcons);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MarketPetConSet> getSubid2petconsAsData()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*      */     
/*  388 */     CustommizedCons _o_ = this;
/*  389 */     Map<Integer, xbean.MarketPetConSet> subid2petcons = new HashMap();
/*  390 */     for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : _o_.subid2petcons.entrySet())
/*  391 */       subid2petcons.put(_e_.getKey(), new MarketPetConSet.Data((xbean.MarketPetConSet)_e_.getValue()));
/*  392 */     return subid2petcons;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MarketPetEquipConSet> getSubid2petequipcons()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     return xdb.Logs.logMap(new LogKey(this, "subid2petequipcons"), this.subid2petequipcons);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MarketPetEquipConSet> getSubid2petequipconsAsData()
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*      */     
/*  409 */     CustommizedCons _o_ = this;
/*  410 */     Map<Integer, xbean.MarketPetEquipConSet> subid2petequipcons = new HashMap();
/*  411 */     for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : _o_.subid2petequipcons.entrySet())
/*  412 */       subid2petequipcons.put(_e_.getKey(), new MarketPetEquipConSet.Data((xbean.MarketPetEquipConSet)_e_.getValue()));
/*  413 */     return subid2petequipcons;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastsearchtime(long _v_)
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     xdb.Logs.logIf(new LogKey(this, "lastsearchtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  425 */         new xdb.logs.LogLong(this, CustommizedCons.this.lastsearchtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  429 */             CustommizedCons.this.lastsearchtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  433 */     });
/*  434 */     this.lastsearchtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     CustommizedCons _o_ = null;
/*  442 */     if ((_o1_ instanceof CustommizedCons)) { _o_ = (CustommizedCons)_o1_;
/*  443 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  444 */       return false;
/*  445 */     if (this.lastsearchtime != _o_.lastsearchtime) return false;
/*  446 */     if (!this.subid2equipcons.equals(_o_.subid2equipcons)) return false;
/*  447 */     if (!this.subid2petcons.equals(_o_.subid2petcons)) return false;
/*  448 */     if (!this.subid2petequipcons.equals(_o_.subid2petequipcons)) return false;
/*  449 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     int _h_ = 0;
/*  457 */     _h_ = (int)(_h_ + this.lastsearchtime);
/*  458 */     _h_ += this.subid2equipcons.hashCode();
/*  459 */     _h_ += this.subid2petcons.hashCode();
/*  460 */     _h_ += this.subid2petequipcons.hashCode();
/*  461 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     StringBuilder _sb_ = new StringBuilder();
/*  469 */     _sb_.append("(");
/*  470 */     _sb_.append(this.lastsearchtime);
/*  471 */     _sb_.append(",");
/*  472 */     _sb_.append(this.subid2equipcons);
/*  473 */     _sb_.append(",");
/*  474 */     _sb_.append(this.subid2petcons);
/*  475 */     _sb_.append(",");
/*  476 */     _sb_.append(this.subid2petequipcons);
/*  477 */     _sb_.append(")");
/*  478 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  484 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  485 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastsearchtime"));
/*  486 */     lb.add(new xdb.logs.ListenableMap().setVarName("subid2equipcons"));
/*  487 */     lb.add(new xdb.logs.ListenableMap().setVarName("subid2petcons"));
/*  488 */     lb.add(new xdb.logs.ListenableMap().setVarName("subid2petequipcons"));
/*  489 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CustommizedCons {
/*      */     private Const() {}
/*      */     
/*      */     CustommizedCons nThis() {
/*  496 */       return CustommizedCons.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  502 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CustommizedCons copy()
/*      */     {
/*  508 */       return CustommizedCons.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CustommizedCons toData()
/*      */     {
/*  514 */       return CustommizedCons.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CustommizedCons toBean()
/*      */     {
/*  519 */       return CustommizedCons.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CustommizedCons toDataIf()
/*      */     {
/*  525 */       return CustommizedCons.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CustommizedCons toBeanIf()
/*      */     {
/*  530 */       return CustommizedCons.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastsearchtime()
/*      */     {
/*  537 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  538 */       return CustommizedCons.this.lastsearchtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketEquipConSet> getSubid2equipcons()
/*      */     {
/*  545 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  546 */       return xdb.Consts.constMap(CustommizedCons.this.subid2equipcons);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketEquipConSet> getSubid2equipconsAsData()
/*      */     {
/*  553 */       CustommizedCons.this._xdb_verify_unsafe_();
/*      */       
/*  555 */       CustommizedCons _o_ = CustommizedCons.this;
/*  556 */       Map<Integer, xbean.MarketEquipConSet> subid2equipcons = new HashMap();
/*  557 */       for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : _o_.subid2equipcons.entrySet())
/*  558 */         subid2equipcons.put(_e_.getKey(), new MarketEquipConSet.Data((xbean.MarketEquipConSet)_e_.getValue()));
/*  559 */       return subid2equipcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetConSet> getSubid2petcons()
/*      */     {
/*  566 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  567 */       return xdb.Consts.constMap(CustommizedCons.this.subid2petcons);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetConSet> getSubid2petconsAsData()
/*      */     {
/*  574 */       CustommizedCons.this._xdb_verify_unsafe_();
/*      */       
/*  576 */       CustommizedCons _o_ = CustommizedCons.this;
/*  577 */       Map<Integer, xbean.MarketPetConSet> subid2petcons = new HashMap();
/*  578 */       for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : _o_.subid2petcons.entrySet())
/*  579 */         subid2petcons.put(_e_.getKey(), new MarketPetConSet.Data((xbean.MarketPetConSet)_e_.getValue()));
/*  580 */       return subid2petcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetEquipConSet> getSubid2petequipcons()
/*      */     {
/*  587 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  588 */       return xdb.Consts.constMap(CustommizedCons.this.subid2petequipcons);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetEquipConSet> getSubid2petequipconsAsData()
/*      */     {
/*  595 */       CustommizedCons.this._xdb_verify_unsafe_();
/*      */       
/*  597 */       CustommizedCons _o_ = CustommizedCons.this;
/*  598 */       Map<Integer, xbean.MarketPetEquipConSet> subid2petequipcons = new HashMap();
/*  599 */       for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : _o_.subid2petequipcons.entrySet())
/*  600 */         subid2petequipcons.put(_e_.getKey(), new MarketPetEquipConSet.Data((xbean.MarketPetEquipConSet)_e_.getValue()));
/*  601 */       return subid2petequipcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastsearchtime(long _v_)
/*      */     {
/*  608 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  609 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  615 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  616 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  622 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  623 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  629 */       return CustommizedCons.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  635 */       return CustommizedCons.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  641 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  642 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  648 */       return CustommizedCons.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  654 */       return CustommizedCons.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  660 */       CustommizedCons.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  667 */       return CustommizedCons.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  673 */       return CustommizedCons.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  679 */       return CustommizedCons.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  685 */       return CustommizedCons.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  691 */       return CustommizedCons.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  697 */       return CustommizedCons.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  703 */       return CustommizedCons.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CustommizedCons
/*      */   {
/*      */     private long lastsearchtime;
/*      */     
/*      */     private HashMap<Integer, xbean.MarketEquipConSet> subid2equipcons;
/*      */     
/*      */     private HashMap<Integer, xbean.MarketPetConSet> subid2petcons;
/*      */     
/*      */     private HashMap<Integer, xbean.MarketPetEquipConSet> subid2petequipcons;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  726 */       this.subid2equipcons = new HashMap();
/*  727 */       this.subid2petcons = new HashMap();
/*  728 */       this.subid2petequipcons = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.CustommizedCons _o1_)
/*      */     {
/*  733 */       if ((_o1_ instanceof CustommizedCons)) { assign((CustommizedCons)_o1_);
/*  734 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  735 */       } else if ((_o1_ instanceof CustommizedCons.Const)) assign(((CustommizedCons.Const)_o1_).nThis()); else {
/*  736 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CustommizedCons _o_) {
/*  741 */       this.lastsearchtime = _o_.lastsearchtime;
/*  742 */       this.subid2equipcons = new HashMap();
/*  743 */       for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : _o_.subid2equipcons.entrySet())
/*  744 */         this.subid2equipcons.put(_e_.getKey(), new MarketEquipConSet.Data((xbean.MarketEquipConSet)_e_.getValue()));
/*  745 */       this.subid2petcons = new HashMap();
/*  746 */       for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : _o_.subid2petcons.entrySet())
/*  747 */         this.subid2petcons.put(_e_.getKey(), new MarketPetConSet.Data((xbean.MarketPetConSet)_e_.getValue()));
/*  748 */       this.subid2petequipcons = new HashMap();
/*  749 */       for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : _o_.subid2petequipcons.entrySet()) {
/*  750 */         this.subid2petequipcons.put(_e_.getKey(), new MarketPetEquipConSet.Data((xbean.MarketPetEquipConSet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  755 */       this.lastsearchtime = _o_.lastsearchtime;
/*  756 */       this.subid2equipcons = new HashMap();
/*  757 */       for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : _o_.subid2equipcons.entrySet())
/*  758 */         this.subid2equipcons.put(_e_.getKey(), new MarketEquipConSet.Data((xbean.MarketEquipConSet)_e_.getValue()));
/*  759 */       this.subid2petcons = new HashMap();
/*  760 */       for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : _o_.subid2petcons.entrySet())
/*  761 */         this.subid2petcons.put(_e_.getKey(), new MarketPetConSet.Data((xbean.MarketPetConSet)_e_.getValue()));
/*  762 */       this.subid2petequipcons = new HashMap();
/*  763 */       for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : _o_.subid2petequipcons.entrySet()) {
/*  764 */         this.subid2petequipcons.put(_e_.getKey(), new MarketPetEquipConSet.Data((xbean.MarketPetEquipConSet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  770 */       _os_.marshal(this.lastsearchtime);
/*  771 */       _os_.compact_uint32(this.subid2equipcons.size());
/*  772 */       for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : this.subid2equipcons.entrySet())
/*      */       {
/*  774 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  775 */         ((xbean.MarketEquipConSet)_e_.getValue()).marshal(_os_);
/*      */       }
/*  777 */       _os_.compact_uint32(this.subid2petcons.size());
/*  778 */       for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : this.subid2petcons.entrySet())
/*      */       {
/*  780 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  781 */         ((xbean.MarketPetConSet)_e_.getValue()).marshal(_os_);
/*      */       }
/*  783 */       _os_.compact_uint32(this.subid2petequipcons.size());
/*  784 */       for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : this.subid2petequipcons.entrySet())
/*      */       {
/*  786 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  787 */         ((xbean.MarketPetEquipConSet)_e_.getValue()).marshal(_os_);
/*      */       }
/*  789 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  795 */       this.lastsearchtime = _os_.unmarshal_long();
/*      */       
/*  797 */       int size = _os_.uncompact_uint32();
/*  798 */       if (size >= 12)
/*      */       {
/*  800 */         this.subid2equipcons = new HashMap(size * 2);
/*      */       }
/*  802 */       for (; size > 0; size--)
/*      */       {
/*  804 */         int _k_ = 0;
/*  805 */         _k_ = _os_.unmarshal_int();
/*  806 */         xbean.MarketEquipConSet _v_ = xbean.Pod.newMarketEquipConSetData();
/*  807 */         _v_.unmarshal(_os_);
/*  808 */         this.subid2equipcons.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  812 */       int size = _os_.uncompact_uint32();
/*  813 */       if (size >= 12)
/*      */       {
/*  815 */         this.subid2petcons = new HashMap(size * 2);
/*      */       }
/*  817 */       for (; size > 0; size--)
/*      */       {
/*  819 */         int _k_ = 0;
/*  820 */         _k_ = _os_.unmarshal_int();
/*  821 */         xbean.MarketPetConSet _v_ = xbean.Pod.newMarketPetConSetData();
/*  822 */         _v_.unmarshal(_os_);
/*  823 */         this.subid2petcons.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  827 */       int size = _os_.uncompact_uint32();
/*  828 */       if (size >= 12)
/*      */       {
/*  830 */         this.subid2petequipcons = new HashMap(size * 2);
/*      */       }
/*  832 */       for (; size > 0; size--)
/*      */       {
/*  834 */         int _k_ = 0;
/*  835 */         _k_ = _os_.unmarshal_int();
/*  836 */         xbean.MarketPetEquipConSet _v_ = xbean.Pod.newMarketPetEquipConSetData();
/*  837 */         _v_.unmarshal(_os_);
/*  838 */         this.subid2petequipcons.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  841 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  847 */       int _size_ = 0;
/*  848 */       _size_ += CodedOutputStream.computeInt64Size(1, this.lastsearchtime);
/*  849 */       for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : this.subid2equipcons.entrySet())
/*      */       {
/*  851 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  852 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */       }
/*  854 */       for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : this.subid2petcons.entrySet())
/*      */       {
/*  856 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  857 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/*  859 */       for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : this.subid2petequipcons.entrySet())
/*      */       {
/*  861 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  862 */         _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */       }
/*  864 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  872 */         _output_.writeInt64(1, this.lastsearchtime);
/*  873 */         for (Map.Entry<Integer, xbean.MarketEquipConSet> _e_ : this.subid2equipcons.entrySet())
/*      */         {
/*  875 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  876 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*      */         }
/*  878 */         for (Map.Entry<Integer, xbean.MarketPetConSet> _e_ : this.subid2petcons.entrySet())
/*      */         {
/*  880 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  881 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/*  883 */         for (Map.Entry<Integer, xbean.MarketPetEquipConSet> _e_ : this.subid2petequipcons.entrySet())
/*      */         {
/*  885 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  886 */           _output_.writeMessage(4, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  891 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  893 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  901 */         boolean done = false;
/*  902 */         while (!done)
/*      */         {
/*  904 */           int tag = _input_.readTag();
/*  905 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  909 */             done = true;
/*  910 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  914 */             this.lastsearchtime = _input_.readInt64();
/*  915 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  919 */             int _k_ = 0;
/*  920 */             _k_ = _input_.readInt32();
/*  921 */             int readTag = _input_.readTag();
/*  922 */             if (18 != readTag)
/*      */             {
/*  924 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  926 */             xbean.MarketEquipConSet _v_ = xbean.Pod.newMarketEquipConSetData();
/*  927 */             _input_.readMessage(_v_);
/*  928 */             this.subid2equipcons.put(Integer.valueOf(_k_), _v_);
/*  929 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  933 */             int _k_ = 0;
/*  934 */             _k_ = _input_.readInt32();
/*  935 */             int readTag = _input_.readTag();
/*  936 */             if (26 != readTag)
/*      */             {
/*  938 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  940 */             xbean.MarketPetConSet _v_ = xbean.Pod.newMarketPetConSetData();
/*  941 */             _input_.readMessage(_v_);
/*  942 */             this.subid2petcons.put(Integer.valueOf(_k_), _v_);
/*  943 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  947 */             int _k_ = 0;
/*  948 */             _k_ = _input_.readInt32();
/*  949 */             int readTag = _input_.readTag();
/*  950 */             if (34 != readTag)
/*      */             {
/*  952 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  954 */             xbean.MarketPetEquipConSet _v_ = xbean.Pod.newMarketPetEquipConSetData();
/*  955 */             _input_.readMessage(_v_);
/*  956 */             this.subid2petequipcons.put(Integer.valueOf(_k_), _v_);
/*  957 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  961 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  963 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  972 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  976 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  978 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CustommizedCons copy()
/*      */     {
/*  984 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CustommizedCons toData()
/*      */     {
/*  990 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CustommizedCons toBean()
/*      */     {
/*  995 */       return new CustommizedCons(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CustommizedCons toDataIf()
/*      */     {
/* 1001 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CustommizedCons toBeanIf()
/*      */     {
/* 1006 */       return new CustommizedCons(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1012 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1016 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1020 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1024 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1028 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1032 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1036 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastsearchtime()
/*      */     {
/* 1043 */       return this.lastsearchtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketEquipConSet> getSubid2equipcons()
/*      */     {
/* 1050 */       return this.subid2equipcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketEquipConSet> getSubid2equipconsAsData()
/*      */     {
/* 1057 */       return this.subid2equipcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetConSet> getSubid2petcons()
/*      */     {
/* 1064 */       return this.subid2petcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetConSet> getSubid2petconsAsData()
/*      */     {
/* 1071 */       return this.subid2petcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetEquipConSet> getSubid2petequipcons()
/*      */     {
/* 1078 */       return this.subid2petequipcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MarketPetEquipConSet> getSubid2petequipconsAsData()
/*      */     {
/* 1085 */       return this.subid2petequipcons;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastsearchtime(long _v_)
/*      */     {
/* 1092 */       this.lastsearchtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1098 */       if (!(_o1_ instanceof Data)) return false;
/* 1099 */       Data _o_ = (Data)_o1_;
/* 1100 */       if (this.lastsearchtime != _o_.lastsearchtime) return false;
/* 1101 */       if (!this.subid2equipcons.equals(_o_.subid2equipcons)) return false;
/* 1102 */       if (!this.subid2petcons.equals(_o_.subid2petcons)) return false;
/* 1103 */       if (!this.subid2petequipcons.equals(_o_.subid2petequipcons)) return false;
/* 1104 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1110 */       int _h_ = 0;
/* 1111 */       _h_ = (int)(_h_ + this.lastsearchtime);
/* 1112 */       _h_ += this.subid2equipcons.hashCode();
/* 1113 */       _h_ += this.subid2petcons.hashCode();
/* 1114 */       _h_ += this.subid2petequipcons.hashCode();
/* 1115 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1121 */       StringBuilder _sb_ = new StringBuilder();
/* 1122 */       _sb_.append("(");
/* 1123 */       _sb_.append(this.lastsearchtime);
/* 1124 */       _sb_.append(",");
/* 1125 */       _sb_.append(this.subid2equipcons);
/* 1126 */       _sb_.append(",");
/* 1127 */       _sb_.append(this.subid2petcons);
/* 1128 */       _sb_.append(",");
/* 1129 */       _sb_.append(this.subid2petequipcons);
/* 1130 */       _sb_.append(")");
/* 1131 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CustommizedCons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */