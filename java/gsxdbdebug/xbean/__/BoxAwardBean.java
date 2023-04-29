/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class BoxAwardBean extends XBean implements xbean.BoxAwardBean
/*      */ {
/*      */   private ArrayList<Long> roleids;
/*      */   private HashMap<Long, xbean.AwardBean> awardrolemap;
/*      */   private HashMap<Long, Integer> rollrolemap;
/*      */   private ArrayList<Integer> awarditemids;
/*      */   private int index;
/*      */   private ArrayList<Long> operroleids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleids.clear();
/*   29 */     this.awardrolemap.clear();
/*   30 */     this.rollrolemap.clear();
/*   31 */     this.awarditemids.clear();
/*   32 */     this.index = 0;
/*   33 */     this.operroleids.clear();
/*      */   }
/*      */   
/*      */   BoxAwardBean(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.roleids = new ArrayList();
/*   40 */     this.awardrolemap = new HashMap();
/*   41 */     this.rollrolemap = new HashMap();
/*   42 */     this.awarditemids = new ArrayList();
/*   43 */     this.operroleids = new ArrayList();
/*      */   }
/*      */   
/*      */   public BoxAwardBean()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BoxAwardBean(BoxAwardBean _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BoxAwardBean(xbean.BoxAwardBean _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof BoxAwardBean)) { assign((BoxAwardBean)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BoxAwardBean _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.roleids = new ArrayList();
/*   69 */     this.roleids.addAll(_o_.roleids);
/*   70 */     this.awardrolemap = new HashMap();
/*   71 */     for (Map.Entry<Long, xbean.AwardBean> _e_ : _o_.awardrolemap.entrySet())
/*   72 */       this.awardrolemap.put(_e_.getKey(), new AwardBean((xbean.AwardBean)_e_.getValue(), this, "awardrolemap"));
/*   73 */     this.rollrolemap = new HashMap();
/*   74 */     for (Map.Entry<Long, Integer> _e_ : _o_.rollrolemap.entrySet())
/*   75 */       this.rollrolemap.put(_e_.getKey(), _e_.getValue());
/*   76 */     this.awarditemids = new ArrayList();
/*   77 */     this.awarditemids.addAll(_o_.awarditemids);
/*   78 */     this.index = _o_.index;
/*   79 */     this.operroleids = new ArrayList();
/*   80 */     this.operroleids.addAll(_o_.operroleids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   85 */     this.roleids = new ArrayList();
/*   86 */     this.roleids.addAll(_o_.roleids);
/*   87 */     this.awardrolemap = new HashMap();
/*   88 */     for (Map.Entry<Long, xbean.AwardBean> _e_ : _o_.awardrolemap.entrySet())
/*   89 */       this.awardrolemap.put(_e_.getKey(), new AwardBean((xbean.AwardBean)_e_.getValue(), this, "awardrolemap"));
/*   90 */     this.rollrolemap = new HashMap();
/*   91 */     for (Map.Entry<Long, Integer> _e_ : _o_.rollrolemap.entrySet())
/*   92 */       this.rollrolemap.put(_e_.getKey(), _e_.getValue());
/*   93 */     this.awarditemids = new ArrayList();
/*   94 */     this.awarditemids.addAll(_o_.awarditemids);
/*   95 */     this.index = _o_.index;
/*   96 */     this.operroleids = new ArrayList();
/*   97 */     this.operroleids.addAll(_o_.operroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     _os_.compact_uint32(this.roleids.size());
/*  105 */     for (Long _v_ : this.roleids)
/*      */     {
/*  107 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  109 */     _os_.compact_uint32(this.awardrolemap.size());
/*  110 */     for (Map.Entry<Long, xbean.AwardBean> _e_ : this.awardrolemap.entrySet())
/*      */     {
/*  112 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  113 */       ((xbean.AwardBean)_e_.getValue()).marshal(_os_);
/*      */     }
/*  115 */     _os_.compact_uint32(this.rollrolemap.size());
/*  116 */     for (Map.Entry<Long, Integer> _e_ : this.rollrolemap.entrySet())
/*      */     {
/*  118 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  119 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  121 */     _os_.compact_uint32(this.awarditemids.size());
/*  122 */     for (Integer _v_ : this.awarditemids)
/*      */     {
/*  124 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  126 */     _os_.marshal(this.index);
/*  127 */     _os_.compact_uint32(this.operroleids.size());
/*  128 */     for (Long _v_ : this.operroleids)
/*      */     {
/*  130 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  132 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  138 */     _xdb_verify_unsafe_();
/*  139 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  141 */       long _v_ = 0L;
/*  142 */       _v_ = _os_.unmarshal_long();
/*  143 */       this.roleids.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  146 */     int size = _os_.uncompact_uint32();
/*  147 */     if (size >= 12)
/*      */     {
/*  149 */       this.awardrolemap = new HashMap(size * 2);
/*      */     }
/*  151 */     for (; size > 0; size--)
/*      */     {
/*  153 */       long _k_ = 0L;
/*  154 */       _k_ = _os_.unmarshal_long();
/*  155 */       xbean.AwardBean _v_ = new AwardBean(0, this, "awardrolemap");
/*  156 */       _v_.unmarshal(_os_);
/*  157 */       this.awardrolemap.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  161 */     int size = _os_.uncompact_uint32();
/*  162 */     if (size >= 12)
/*      */     {
/*  164 */       this.rollrolemap = new HashMap(size * 2);
/*      */     }
/*  166 */     for (; size > 0; size--)
/*      */     {
/*  168 */       long _k_ = 0L;
/*  169 */       _k_ = _os_.unmarshal_long();
/*  170 */       int _v_ = 0;
/*  171 */       _v_ = _os_.unmarshal_int();
/*  172 */       this.rollrolemap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  175 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  177 */       int _v_ = 0;
/*  178 */       _v_ = _os_.unmarshal_int();
/*  179 */       this.awarditemids.add(Integer.valueOf(_v_));
/*      */     }
/*  181 */     this.index = _os_.unmarshal_int();
/*  182 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  184 */       long _v_ = 0L;
/*  185 */       _v_ = _os_.unmarshal_long();
/*  186 */       this.operroleids.add(Long.valueOf(_v_));
/*      */     }
/*  188 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  194 */     _xdb_verify_unsafe_();
/*  195 */     int _size_ = 0;
/*  196 */     for (Long _v_ : this.roleids)
/*      */     {
/*  198 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */     }
/*  200 */     for (Map.Entry<Long, xbean.AwardBean> _e_ : this.awardrolemap.entrySet())
/*      */     {
/*  202 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  203 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  205 */     for (Map.Entry<Long, Integer> _e_ : this.rollrolemap.entrySet())
/*      */     {
/*  207 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  208 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  210 */     for (Integer _v_ : this.awarditemids)
/*      */     {
/*  212 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */     }
/*  214 */     _size_ += CodedOutputStream.computeInt32Size(5, this.index);
/*  215 */     for (Long _v_ : this.operroleids)
/*      */     {
/*  217 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  219 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  225 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  228 */       for (Long _v_ : this.roleids)
/*      */       {
/*  230 */         _output_.writeInt64(1, _v_.longValue());
/*      */       }
/*  232 */       for (Map.Entry<Long, xbean.AwardBean> _e_ : this.awardrolemap.entrySet())
/*      */       {
/*  234 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  235 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  237 */       for (Map.Entry<Long, Integer> _e_ : this.rollrolemap.entrySet())
/*      */       {
/*  239 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  240 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  242 */       for (Integer _v_ : this.awarditemids)
/*      */       {
/*  244 */         _output_.writeInt32(4, _v_.intValue());
/*      */       }
/*  246 */       _output_.writeInt32(5, this.index);
/*  247 */       for (Long _v_ : this.operroleids)
/*      */       {
/*  249 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  254 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  256 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  265 */       boolean done = false;
/*  266 */       while (!done)
/*      */       {
/*  268 */         int tag = _input_.readTag();
/*  269 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  273 */           done = true;
/*  274 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  278 */           long _v_ = 0L;
/*  279 */           _v_ = _input_.readInt64();
/*  280 */           this.roleids.add(Long.valueOf(_v_));
/*  281 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  285 */           long _k_ = 0L;
/*  286 */           _k_ = _input_.readInt64();
/*  287 */           int readTag = _input_.readTag();
/*  288 */           if (18 != readTag)
/*      */           {
/*  290 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  292 */           xbean.AwardBean _v_ = new AwardBean(0, this, "awardrolemap");
/*  293 */           _input_.readMessage(_v_);
/*  294 */           this.awardrolemap.put(Long.valueOf(_k_), _v_);
/*  295 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  299 */           long _k_ = 0L;
/*  300 */           _k_ = _input_.readInt64();
/*  301 */           int readTag = _input_.readTag();
/*  302 */           if (24 != readTag)
/*      */           {
/*  304 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  306 */           int _v_ = 0;
/*  307 */           _v_ = _input_.readInt32();
/*  308 */           this.rollrolemap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  309 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  313 */           int _v_ = 0;
/*  314 */           _v_ = _input_.readInt32();
/*  315 */           this.awarditemids.add(Integer.valueOf(_v_));
/*  316 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  320 */           this.index = _input_.readInt32();
/*  321 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  325 */           long _v_ = 0L;
/*  326 */           _v_ = _input_.readInt64();
/*  327 */           this.operroleids.add(Long.valueOf(_v_));
/*  328 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  332 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  334 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  343 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  347 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  349 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BoxAwardBean copy()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return new BoxAwardBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BoxAwardBean toData()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BoxAwardBean toBean()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return new BoxAwardBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BoxAwardBean toDataIf()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*  376 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BoxAwardBean toBeanIf()
/*      */   {
/*  381 */     _xdb_verify_unsafe_();
/*  382 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRoleids()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     return xdb.Logs.logList(new LogKey(this, "roleids"), this.roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRoleidsAsData()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*      */     
/*  405 */     BoxAwardBean _o_ = this;
/*  406 */     List<Long> roleids = new ArrayList();
/*  407 */     roleids.addAll(_o_.roleids);
/*  408 */     return roleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.AwardBean> getAwardrolemap()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     return xdb.Logs.logMap(new LogKey(this, "awardrolemap"), this.awardrolemap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.AwardBean> getAwardrolemapAsData()
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*      */     
/*  425 */     BoxAwardBean _o_ = this;
/*  426 */     Map<Long, xbean.AwardBean> awardrolemap = new HashMap();
/*  427 */     for (Map.Entry<Long, xbean.AwardBean> _e_ : _o_.awardrolemap.entrySet())
/*  428 */       awardrolemap.put(_e_.getKey(), new AwardBean.Data((xbean.AwardBean)_e_.getValue()));
/*  429 */     return awardrolemap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRollrolemap()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     return xdb.Logs.logMap(new LogKey(this, "rollrolemap"), this.rollrolemap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRollrolemapAsData()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*      */     
/*  446 */     BoxAwardBean _o_ = this;
/*  447 */     Map<Long, Integer> rollrolemap = new HashMap();
/*  448 */     for (Map.Entry<Long, Integer> _e_ : _o_.rollrolemap.entrySet())
/*  449 */       rollrolemap.put(_e_.getKey(), _e_.getValue());
/*  450 */     return rollrolemap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getAwarditemids()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     return xdb.Logs.logList(new LogKey(this, "awarditemids"), this.awarditemids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getAwarditemidsAsData()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*      */     
/*  466 */     BoxAwardBean _o_ = this;
/*  467 */     List<Integer> awarditemids = new ArrayList();
/*  468 */     awarditemids.addAll(_o_.awarditemids);
/*  469 */     return awarditemids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIndex()
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     return this.index;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getOperroleids()
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     return xdb.Logs.logList(new LogKey(this, "operroleids"), this.operroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getOperroleidsAsData()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*      */     
/*  493 */     BoxAwardBean _o_ = this;
/*  494 */     List<Long> operroleids = new ArrayList();
/*  495 */     operroleids.addAll(_o_.operroleids);
/*  496 */     return operroleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIndex(int _v_)
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     xdb.Logs.logIf(new LogKey(this, "index")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  508 */         new xdb.logs.LogInt(this, BoxAwardBean.this.index)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  512 */             BoxAwardBean.this.index = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  516 */     });
/*  517 */     this.index = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     BoxAwardBean _o_ = null;
/*  525 */     if ((_o1_ instanceof BoxAwardBean)) { _o_ = (BoxAwardBean)_o1_;
/*  526 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  527 */       return false;
/*  528 */     if (!this.roleids.equals(_o_.roleids)) return false;
/*  529 */     if (!this.awardrolemap.equals(_o_.awardrolemap)) return false;
/*  530 */     if (!this.rollrolemap.equals(_o_.rollrolemap)) return false;
/*  531 */     if (!this.awarditemids.equals(_o_.awarditemids)) return false;
/*  532 */     if (this.index != _o_.index) return false;
/*  533 */     if (!this.operroleids.equals(_o_.operroleids)) return false;
/*  534 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  540 */     _xdb_verify_unsafe_();
/*  541 */     int _h_ = 0;
/*  542 */     _h_ += this.roleids.hashCode();
/*  543 */     _h_ += this.awardrolemap.hashCode();
/*  544 */     _h_ += this.rollrolemap.hashCode();
/*  545 */     _h_ += this.awarditemids.hashCode();
/*  546 */     _h_ += this.index;
/*  547 */     _h_ += this.operroleids.hashCode();
/*  548 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  554 */     _xdb_verify_unsafe_();
/*  555 */     StringBuilder _sb_ = new StringBuilder();
/*  556 */     _sb_.append("(");
/*  557 */     _sb_.append(this.roleids);
/*  558 */     _sb_.append(",");
/*  559 */     _sb_.append(this.awardrolemap);
/*  560 */     _sb_.append(",");
/*  561 */     _sb_.append(this.rollrolemap);
/*  562 */     _sb_.append(",");
/*  563 */     _sb_.append(this.awarditemids);
/*  564 */     _sb_.append(",");
/*  565 */     _sb_.append(this.index);
/*  566 */     _sb_.append(",");
/*  567 */     _sb_.append(this.operroleids);
/*  568 */     _sb_.append(")");
/*  569 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  575 */     ListenableBean lb = new ListenableBean();
/*  576 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleids"));
/*  577 */     lb.add(new xdb.logs.ListenableMap().setVarName("awardrolemap"));
/*  578 */     lb.add(new xdb.logs.ListenableMap().setVarName("rollrolemap"));
/*  579 */     lb.add(new xdb.logs.ListenableChanged().setVarName("awarditemids"));
/*  580 */     lb.add(new xdb.logs.ListenableChanged().setVarName("index"));
/*  581 */     lb.add(new xdb.logs.ListenableChanged().setVarName("operroleids"));
/*  582 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BoxAwardBean {
/*      */     private Const() {}
/*      */     
/*      */     BoxAwardBean nThis() {
/*  589 */       return BoxAwardBean.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  595 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BoxAwardBean copy()
/*      */     {
/*  601 */       return BoxAwardBean.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BoxAwardBean toData()
/*      */     {
/*  607 */       return BoxAwardBean.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BoxAwardBean toBean()
/*      */     {
/*  612 */       return BoxAwardBean.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BoxAwardBean toDataIf()
/*      */     {
/*  618 */       return BoxAwardBean.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BoxAwardBean toBeanIf()
/*      */     {
/*  623 */       return BoxAwardBean.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/*  630 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  631 */       return xdb.Consts.constList(BoxAwardBean.this.roleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/*  637 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  639 */       BoxAwardBean _o_ = BoxAwardBean.this;
/*  640 */       List<Long> roleids = new ArrayList();
/*  641 */       roleids.addAll(_o_.roleids);
/*  642 */       return roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AwardBean> getAwardrolemap()
/*      */     {
/*  649 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  650 */       return xdb.Consts.constMap(BoxAwardBean.this.awardrolemap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AwardBean> getAwardrolemapAsData()
/*      */     {
/*  657 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  659 */       BoxAwardBean _o_ = BoxAwardBean.this;
/*  660 */       Map<Long, xbean.AwardBean> awardrolemap = new HashMap();
/*  661 */       for (Map.Entry<Long, xbean.AwardBean> _e_ : _o_.awardrolemap.entrySet())
/*  662 */         awardrolemap.put(_e_.getKey(), new AwardBean.Data((xbean.AwardBean)_e_.getValue()));
/*  663 */       return awardrolemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRollrolemap()
/*      */     {
/*  670 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  671 */       return xdb.Consts.constMap(BoxAwardBean.this.rollrolemap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRollrolemapAsData()
/*      */     {
/*  678 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  680 */       BoxAwardBean _o_ = BoxAwardBean.this;
/*  681 */       Map<Long, Integer> rollrolemap = new HashMap();
/*  682 */       for (Map.Entry<Long, Integer> _e_ : _o_.rollrolemap.entrySet())
/*  683 */         rollrolemap.put(_e_.getKey(), _e_.getValue());
/*  684 */       return rollrolemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAwarditemids()
/*      */     {
/*  691 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  692 */       return xdb.Consts.constList(BoxAwardBean.this.awarditemids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getAwarditemidsAsData()
/*      */     {
/*  698 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  700 */       BoxAwardBean _o_ = BoxAwardBean.this;
/*  701 */       List<Integer> awarditemids = new ArrayList();
/*  702 */       awarditemids.addAll(_o_.awarditemids);
/*  703 */       return awarditemids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIndex()
/*      */     {
/*  710 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  711 */       return BoxAwardBean.this.index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOperroleids()
/*      */     {
/*  718 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  719 */       return xdb.Consts.constList(BoxAwardBean.this.operroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getOperroleidsAsData()
/*      */     {
/*  725 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  727 */       BoxAwardBean _o_ = BoxAwardBean.this;
/*  728 */       List<Long> operroleids = new ArrayList();
/*  729 */       operroleids.addAll(_o_.operroleids);
/*  730 */       return operroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIndex(int _v_)
/*      */     {
/*  737 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  738 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  744 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  745 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  751 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  752 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  758 */       return BoxAwardBean.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  764 */       return BoxAwardBean.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  770 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  771 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  777 */       return BoxAwardBean.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  783 */       return BoxAwardBean.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  789 */       BoxAwardBean.this._xdb_verify_unsafe_();
/*  790 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  796 */       return BoxAwardBean.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  802 */       return BoxAwardBean.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  808 */       return BoxAwardBean.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  814 */       return BoxAwardBean.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  820 */       return BoxAwardBean.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  826 */       return BoxAwardBean.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  832 */       return BoxAwardBean.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BoxAwardBean
/*      */   {
/*      */     private ArrayList<Long> roleids;
/*      */     
/*      */     private HashMap<Long, xbean.AwardBean> awardrolemap;
/*      */     
/*      */     private HashMap<Long, Integer> rollrolemap;
/*      */     
/*      */     private ArrayList<Integer> awarditemids;
/*      */     
/*      */     private int index;
/*      */     
/*      */     private ArrayList<Long> operroleids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  854 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  859 */       this.roleids = new ArrayList();
/*  860 */       this.awardrolemap = new HashMap();
/*  861 */       this.rollrolemap = new HashMap();
/*  862 */       this.awarditemids = new ArrayList();
/*  863 */       this.operroleids = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.BoxAwardBean _o1_)
/*      */     {
/*  868 */       if ((_o1_ instanceof BoxAwardBean)) { assign((BoxAwardBean)_o1_);
/*  869 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  870 */       } else if ((_o1_ instanceof BoxAwardBean.Const)) assign(((BoxAwardBean.Const)_o1_).nThis()); else {
/*  871 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BoxAwardBean _o_) {
/*  876 */       this.roleids = new ArrayList();
/*  877 */       this.roleids.addAll(_o_.roleids);
/*  878 */       this.awardrolemap = new HashMap();
/*  879 */       for (Map.Entry<Long, xbean.AwardBean> _e_ : _o_.awardrolemap.entrySet())
/*  880 */         this.awardrolemap.put(_e_.getKey(), new AwardBean.Data((xbean.AwardBean)_e_.getValue()));
/*  881 */       this.rollrolemap = new HashMap();
/*  882 */       for (Map.Entry<Long, Integer> _e_ : _o_.rollrolemap.entrySet())
/*  883 */         this.rollrolemap.put(_e_.getKey(), _e_.getValue());
/*  884 */       this.awarditemids = new ArrayList();
/*  885 */       this.awarditemids.addAll(_o_.awarditemids);
/*  886 */       this.index = _o_.index;
/*  887 */       this.operroleids = new ArrayList();
/*  888 */       this.operroleids.addAll(_o_.operroleids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  893 */       this.roleids = new ArrayList();
/*  894 */       this.roleids.addAll(_o_.roleids);
/*  895 */       this.awardrolemap = new HashMap();
/*  896 */       for (Map.Entry<Long, xbean.AwardBean> _e_ : _o_.awardrolemap.entrySet())
/*  897 */         this.awardrolemap.put(_e_.getKey(), new AwardBean.Data((xbean.AwardBean)_e_.getValue()));
/*  898 */       this.rollrolemap = new HashMap();
/*  899 */       for (Map.Entry<Long, Integer> _e_ : _o_.rollrolemap.entrySet())
/*  900 */         this.rollrolemap.put(_e_.getKey(), _e_.getValue());
/*  901 */       this.awarditemids = new ArrayList();
/*  902 */       this.awarditemids.addAll(_o_.awarditemids);
/*  903 */       this.index = _o_.index;
/*  904 */       this.operroleids = new ArrayList();
/*  905 */       this.operroleids.addAll(_o_.operroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  911 */       _os_.compact_uint32(this.roleids.size());
/*  912 */       for (Long _v_ : this.roleids)
/*      */       {
/*  914 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  916 */       _os_.compact_uint32(this.awardrolemap.size());
/*  917 */       for (Map.Entry<Long, xbean.AwardBean> _e_ : this.awardrolemap.entrySet())
/*      */       {
/*  919 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  920 */         ((xbean.AwardBean)_e_.getValue()).marshal(_os_);
/*      */       }
/*  922 */       _os_.compact_uint32(this.rollrolemap.size());
/*  923 */       for (Map.Entry<Long, Integer> _e_ : this.rollrolemap.entrySet())
/*      */       {
/*  925 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  926 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  928 */       _os_.compact_uint32(this.awarditemids.size());
/*  929 */       for (Integer _v_ : this.awarditemids)
/*      */       {
/*  931 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  933 */       _os_.marshal(this.index);
/*  934 */       _os_.compact_uint32(this.operroleids.size());
/*  935 */       for (Long _v_ : this.operroleids)
/*      */       {
/*  937 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  939 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  945 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  947 */         long _v_ = 0L;
/*  948 */         _v_ = _os_.unmarshal_long();
/*  949 */         this.roleids.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  952 */       int size = _os_.uncompact_uint32();
/*  953 */       if (size >= 12)
/*      */       {
/*  955 */         this.awardrolemap = new HashMap(size * 2);
/*      */       }
/*  957 */       for (; size > 0; size--)
/*      */       {
/*  959 */         long _k_ = 0L;
/*  960 */         _k_ = _os_.unmarshal_long();
/*  961 */         xbean.AwardBean _v_ = xbean.Pod.newAwardBeanData();
/*  962 */         _v_.unmarshal(_os_);
/*  963 */         this.awardrolemap.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  967 */       int size = _os_.uncompact_uint32();
/*  968 */       if (size >= 12)
/*      */       {
/*  970 */         this.rollrolemap = new HashMap(size * 2);
/*      */       }
/*  972 */       for (; size > 0; size--)
/*      */       {
/*  974 */         long _k_ = 0L;
/*  975 */         _k_ = _os_.unmarshal_long();
/*  976 */         int _v_ = 0;
/*  977 */         _v_ = _os_.unmarshal_int();
/*  978 */         this.rollrolemap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  981 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  983 */         int _v_ = 0;
/*  984 */         _v_ = _os_.unmarshal_int();
/*  985 */         this.awarditemids.add(Integer.valueOf(_v_));
/*      */       }
/*  987 */       this.index = _os_.unmarshal_int();
/*  988 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  990 */         long _v_ = 0L;
/*  991 */         _v_ = _os_.unmarshal_long();
/*  992 */         this.operroleids.add(Long.valueOf(_v_));
/*      */       }
/*  994 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1000 */       int _size_ = 0;
/* 1001 */       for (Long _v_ : this.roleids)
/*      */       {
/* 1003 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */       }
/* 1005 */       for (Map.Entry<Long, xbean.AwardBean> _e_ : this.awardrolemap.entrySet())
/*      */       {
/* 1007 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 1008 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1010 */       for (Map.Entry<Long, Integer> _e_ : this.rollrolemap.entrySet())
/*      */       {
/* 1012 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 1013 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1015 */       for (Integer _v_ : this.awarditemids)
/*      */       {
/* 1017 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/* 1019 */       _size_ += CodedOutputStream.computeInt32Size(5, this.index);
/* 1020 */       for (Long _v_ : this.operroleids)
/*      */       {
/* 1022 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/* 1024 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1032 */         for (Long _v_ : this.roleids)
/*      */         {
/* 1034 */           _output_.writeInt64(1, _v_.longValue());
/*      */         }
/* 1036 */         for (Map.Entry<Long, xbean.AwardBean> _e_ : this.awardrolemap.entrySet())
/*      */         {
/* 1038 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 1039 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1041 */         for (Map.Entry<Long, Integer> _e_ : this.rollrolemap.entrySet())
/*      */         {
/* 1043 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 1044 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1046 */         for (Integer _v_ : this.awarditemids)
/*      */         {
/* 1048 */           _output_.writeInt32(4, _v_.intValue());
/*      */         }
/* 1050 */         _output_.writeInt32(5, this.index);
/* 1051 */         for (Long _v_ : this.operroleids)
/*      */         {
/* 1053 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1058 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1060 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1068 */         boolean done = false;
/* 1069 */         while (!done)
/*      */         {
/* 1071 */           int tag = _input_.readTag();
/* 1072 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1076 */             done = true;
/* 1077 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1081 */             long _v_ = 0L;
/* 1082 */             _v_ = _input_.readInt64();
/* 1083 */             this.roleids.add(Long.valueOf(_v_));
/* 1084 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1088 */             long _k_ = 0L;
/* 1089 */             _k_ = _input_.readInt64();
/* 1090 */             int readTag = _input_.readTag();
/* 1091 */             if (18 != readTag)
/*      */             {
/* 1093 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1095 */             xbean.AwardBean _v_ = xbean.Pod.newAwardBeanData();
/* 1096 */             _input_.readMessage(_v_);
/* 1097 */             this.awardrolemap.put(Long.valueOf(_k_), _v_);
/* 1098 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1102 */             long _k_ = 0L;
/* 1103 */             _k_ = _input_.readInt64();
/* 1104 */             int readTag = _input_.readTag();
/* 1105 */             if (24 != readTag)
/*      */             {
/* 1107 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1109 */             int _v_ = 0;
/* 1110 */             _v_ = _input_.readInt32();
/* 1111 */             this.rollrolemap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 1112 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1116 */             int _v_ = 0;
/* 1117 */             _v_ = _input_.readInt32();
/* 1118 */             this.awarditemids.add(Integer.valueOf(_v_));
/* 1119 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1123 */             this.index = _input_.readInt32();
/* 1124 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1128 */             long _v_ = 0L;
/* 1129 */             _v_ = _input_.readInt64();
/* 1130 */             this.operroleids.add(Long.valueOf(_v_));
/* 1131 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1135 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1137 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1146 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1150 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1152 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BoxAwardBean copy()
/*      */     {
/* 1158 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BoxAwardBean toData()
/*      */     {
/* 1164 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BoxAwardBean toBean()
/*      */     {
/* 1169 */       return new BoxAwardBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BoxAwardBean toDataIf()
/*      */     {
/* 1175 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BoxAwardBean toBeanIf()
/*      */     {
/* 1180 */       return new BoxAwardBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1186 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1190 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1194 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1198 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1202 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1206 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1210 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/* 1217 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/* 1224 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AwardBean> getAwardrolemap()
/*      */     {
/* 1231 */       return this.awardrolemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.AwardBean> getAwardrolemapAsData()
/*      */     {
/* 1238 */       return this.awardrolemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRollrolemap()
/*      */     {
/* 1245 */       return this.rollrolemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRollrolemapAsData()
/*      */     {
/* 1252 */       return this.rollrolemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAwarditemids()
/*      */     {
/* 1259 */       return this.awarditemids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAwarditemidsAsData()
/*      */     {
/* 1266 */       return this.awarditemids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIndex()
/*      */     {
/* 1273 */       return this.index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOperroleids()
/*      */     {
/* 1280 */       return this.operroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOperroleidsAsData()
/*      */     {
/* 1287 */       return this.operroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIndex(int _v_)
/*      */     {
/* 1294 */       this.index = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1300 */       if (!(_o1_ instanceof Data)) return false;
/* 1301 */       Data _o_ = (Data)_o1_;
/* 1302 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 1303 */       if (!this.awardrolemap.equals(_o_.awardrolemap)) return false;
/* 1304 */       if (!this.rollrolemap.equals(_o_.rollrolemap)) return false;
/* 1305 */       if (!this.awarditemids.equals(_o_.awarditemids)) return false;
/* 1306 */       if (this.index != _o_.index) return false;
/* 1307 */       if (!this.operroleids.equals(_o_.operroleids)) return false;
/* 1308 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1314 */       int _h_ = 0;
/* 1315 */       _h_ += this.roleids.hashCode();
/* 1316 */       _h_ += this.awardrolemap.hashCode();
/* 1317 */       _h_ += this.rollrolemap.hashCode();
/* 1318 */       _h_ += this.awarditemids.hashCode();
/* 1319 */       _h_ += this.index;
/* 1320 */       _h_ += this.operroleids.hashCode();
/* 1321 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1327 */       StringBuilder _sb_ = new StringBuilder();
/* 1328 */       _sb_.append("(");
/* 1329 */       _sb_.append(this.roleids);
/* 1330 */       _sb_.append(",");
/* 1331 */       _sb_.append(this.awardrolemap);
/* 1332 */       _sb_.append(",");
/* 1333 */       _sb_.append(this.rollrolemap);
/* 1334 */       _sb_.append(",");
/* 1335 */       _sb_.append(this.awarditemids);
/* 1336 */       _sb_.append(",");
/* 1337 */       _sb_.append(this.index);
/* 1338 */       _sb_.append(",");
/* 1339 */       _sb_.append(this.operroleids);
/* 1340 */       _sb_.append(")");
/* 1341 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BoxAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */