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
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class SystemAwardBean extends XBean implements xbean.SystemAwardBean
/*      */ {
/*      */   private long starttime;
/*      */   private long endtime;
/*      */   private HashMap<Integer, Integer> itemid2count;
/*      */   private HashMap<Integer, Integer> type2value;
/*      */   private HashMap<Integer, String> contentmap;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.starttime = 0L;
/*   27 */     this.endtime = 0L;
/*   28 */     this.itemid2count.clear();
/*   29 */     this.type2value.clear();
/*   30 */     this.contentmap.clear();
/*      */   }
/*      */   
/*      */   SystemAwardBean(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.starttime = 0L;
/*   37 */     this.endtime = 0L;
/*   38 */     this.itemid2count = new HashMap();
/*   39 */     this.type2value = new HashMap();
/*   40 */     this.contentmap = new HashMap();
/*      */   }
/*      */   
/*      */   public SystemAwardBean()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SystemAwardBean(SystemAwardBean _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SystemAwardBean(xbean.SystemAwardBean _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof SystemAwardBean)) { assign((SystemAwardBean)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(SystemAwardBean _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.starttime = _o_.starttime;
/*   66 */     this.endtime = _o_.endtime;
/*   67 */     this.itemid2count = new HashMap();
/*   68 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2count.entrySet())
/*   69 */       this.itemid2count.put(_e_.getKey(), _e_.getValue());
/*   70 */     this.type2value = new HashMap();
/*   71 */     for (Map.Entry<Integer, Integer> _e_ : _o_.type2value.entrySet())
/*   72 */       this.type2value.put(_e_.getKey(), _e_.getValue());
/*   73 */     this.contentmap = new HashMap();
/*   74 */     for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet()) {
/*   75 */       this.contentmap.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   80 */     this.starttime = _o_.starttime;
/*   81 */     this.endtime = _o_.endtime;
/*   82 */     this.itemid2count = new HashMap();
/*   83 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2count.entrySet())
/*   84 */       this.itemid2count.put(_e_.getKey(), _e_.getValue());
/*   85 */     this.type2value = new HashMap();
/*   86 */     for (Map.Entry<Integer, Integer> _e_ : _o_.type2value.entrySet())
/*   87 */       this.type2value.put(_e_.getKey(), _e_.getValue());
/*   88 */     this.contentmap = new HashMap();
/*   89 */     for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet()) {
/*   90 */       this.contentmap.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     _os_.marshal(this.starttime);
/*   98 */     _os_.marshal(this.endtime);
/*   99 */     _os_.compact_uint32(this.itemid2count.size());
/*  100 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet())
/*      */     {
/*  102 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  103 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  105 */     _os_.compact_uint32(this.type2value.size());
/*  106 */     for (Map.Entry<Integer, Integer> _e_ : this.type2value.entrySet())
/*      */     {
/*  108 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  109 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  111 */     _os_.compact_uint32(this.contentmap.size());
/*  112 */     for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*      */     {
/*  114 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  115 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */     }
/*  117 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  123 */     _xdb_verify_unsafe_();
/*  124 */     this.starttime = _os_.unmarshal_long();
/*  125 */     this.endtime = _os_.unmarshal_long();
/*      */     
/*  127 */     int size = _os_.uncompact_uint32();
/*  128 */     if (size >= 12)
/*      */     {
/*  130 */       this.itemid2count = new HashMap(size * 2);
/*      */     }
/*  132 */     for (; size > 0; size--)
/*      */     {
/*  134 */       int _k_ = 0;
/*  135 */       _k_ = _os_.unmarshal_int();
/*  136 */       int _v_ = 0;
/*  137 */       _v_ = _os_.unmarshal_int();
/*  138 */       this.itemid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  142 */     int size = _os_.uncompact_uint32();
/*  143 */     if (size >= 12)
/*      */     {
/*  145 */       this.type2value = new HashMap(size * 2);
/*      */     }
/*  147 */     for (; size > 0; size--)
/*      */     {
/*  149 */       int _k_ = 0;
/*  150 */       _k_ = _os_.unmarshal_int();
/*  151 */       int _v_ = 0;
/*  152 */       _v_ = _os_.unmarshal_int();
/*  153 */       this.type2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  157 */     int size = _os_.uncompact_uint32();
/*  158 */     if (size >= 12)
/*      */     {
/*  160 */       this.contentmap = new HashMap(size * 2);
/*      */     }
/*  162 */     for (; size > 0; size--)
/*      */     {
/*  164 */       int _k_ = 0;
/*  165 */       _k_ = _os_.unmarshal_int();
/*  166 */       String _v_ = "";
/*  167 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  168 */       this.contentmap.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  171 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  177 */     _xdb_verify_unsafe_();
/*  178 */     int _size_ = 0;
/*  179 */     _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/*  180 */     _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/*  181 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet())
/*      */     {
/*  183 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  184 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  186 */     for (Map.Entry<Integer, Integer> _e_ : this.type2value.entrySet())
/*      */     {
/*  188 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  189 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  191 */     for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*      */     {
/*  193 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*      */       try
/*      */       {
/*  196 */         _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  200 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  203 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  209 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  212 */       _output_.writeInt64(1, this.starttime);
/*  213 */       _output_.writeInt64(2, this.endtime);
/*  214 */       for (Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet())
/*      */       {
/*  216 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  217 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  219 */       for (Map.Entry<Integer, Integer> _e_ : this.type2value.entrySet())
/*      */       {
/*  221 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  222 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  224 */       for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*      */       {
/*  226 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  227 */         _output_.writeBytes(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  232 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  234 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  243 */       boolean done = false;
/*  244 */       while (!done)
/*      */       {
/*  246 */         int tag = _input_.readTag();
/*  247 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  251 */           done = true;
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  256 */           this.starttime = _input_.readInt64();
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  261 */           this.endtime = _input_.readInt64();
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  266 */           int _k_ = 0;
/*  267 */           _k_ = _input_.readInt32();
/*  268 */           int readTag = _input_.readTag();
/*  269 */           if (24 != readTag)
/*      */           {
/*  271 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  273 */           int _v_ = 0;
/*  274 */           _v_ = _input_.readInt32();
/*  275 */           this.itemid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  276 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  280 */           int _k_ = 0;
/*  281 */           _k_ = _input_.readInt32();
/*  282 */           int readTag = _input_.readTag();
/*  283 */           if (32 != readTag)
/*      */           {
/*  285 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  287 */           int _v_ = 0;
/*  288 */           _v_ = _input_.readInt32();
/*  289 */           this.type2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  294 */           int _k_ = 0;
/*  295 */           _k_ = _input_.readInt32();
/*  296 */           int readTag = _input_.readTag();
/*  297 */           if (42 != readTag)
/*      */           {
/*  299 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  301 */           String _v_ = "";
/*  302 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  303 */           this.contentmap.put(Integer.valueOf(_k_), _v_);
/*  304 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  308 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  310 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  319 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  323 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  325 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SystemAwardBean copy()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return new SystemAwardBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SystemAwardBean toData()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SystemAwardBean toBean()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return new SystemAwardBean(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SystemAwardBean toDataIf()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SystemAwardBean toBeanIf()
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  372 */     _xdb_verify_unsafe_();
/*  373 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtime()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return this.endtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getItemid2count()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return xdb.Logs.logMap(new LogKey(this, "itemid2count"), this.itemid2count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getItemid2countAsData()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*      */     
/*  398 */     SystemAwardBean _o_ = this;
/*  399 */     Map<Integer, Integer> itemid2count = new HashMap();
/*  400 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2count.entrySet())
/*  401 */       itemid2count.put(_e_.getKey(), _e_.getValue());
/*  402 */     return itemid2count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getType2value()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return xdb.Logs.logMap(new LogKey(this, "type2value"), this.type2value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getType2valueAsData()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*      */     
/*  419 */     SystemAwardBean _o_ = this;
/*  420 */     Map<Integer, Integer> type2value = new HashMap();
/*  421 */     for (Map.Entry<Integer, Integer> _e_ : _o_.type2value.entrySet())
/*  422 */       type2value.put(_e_.getKey(), _e_.getValue());
/*  423 */     return type2value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, String> getContentmap()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     return xdb.Logs.logMap(new LogKey(this, "contentmap"), this.contentmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, String> getContentmapAsData()
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*      */     
/*  440 */     SystemAwardBean _o_ = this;
/*  441 */     Map<Integer, String> contentmap = new HashMap();
/*  442 */     for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/*  443 */       contentmap.put(_e_.getKey(), _e_.getValue());
/*  444 */     return contentmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  456 */         new xdb.logs.LogLong(this, SystemAwardBean.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  460 */             SystemAwardBean.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  464 */     });
/*  465 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtime(long _v_)
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     xdb.Logs.logIf(new LogKey(this, "endtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  477 */         new xdb.logs.LogLong(this, SystemAwardBean.this.endtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  481 */             SystemAwardBean.this.endtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  485 */     });
/*  486 */     this.endtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  492 */     _xdb_verify_unsafe_();
/*  493 */     SystemAwardBean _o_ = null;
/*  494 */     if ((_o1_ instanceof SystemAwardBean)) { _o_ = (SystemAwardBean)_o1_;
/*  495 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  496 */       return false;
/*  497 */     if (this.starttime != _o_.starttime) return false;
/*  498 */     if (this.endtime != _o_.endtime) return false;
/*  499 */     if (!this.itemid2count.equals(_o_.itemid2count)) return false;
/*  500 */     if (!this.type2value.equals(_o_.type2value)) return false;
/*  501 */     if (!this.contentmap.equals(_o_.contentmap)) return false;
/*  502 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  508 */     _xdb_verify_unsafe_();
/*  509 */     int _h_ = 0;
/*  510 */     _h_ = (int)(_h_ + this.starttime);
/*  511 */     _h_ = (int)(_h_ + this.endtime);
/*  512 */     _h_ += this.itemid2count.hashCode();
/*  513 */     _h_ += this.type2value.hashCode();
/*  514 */     _h_ += this.contentmap.hashCode();
/*  515 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     StringBuilder _sb_ = new StringBuilder();
/*  523 */     _sb_.append("(");
/*  524 */     _sb_.append(this.starttime);
/*  525 */     _sb_.append(",");
/*  526 */     _sb_.append(this.endtime);
/*  527 */     _sb_.append(",");
/*  528 */     _sb_.append(this.itemid2count);
/*  529 */     _sb_.append(",");
/*  530 */     _sb_.append(this.type2value);
/*  531 */     _sb_.append(",");
/*  532 */     _sb_.append(this.contentmap);
/*  533 */     _sb_.append(")");
/*  534 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  540 */     ListenableBean lb = new ListenableBean();
/*  541 */     lb.add(new xdb.logs.ListenableChanged().setVarName("starttime"));
/*  542 */     lb.add(new xdb.logs.ListenableChanged().setVarName("endtime"));
/*  543 */     lb.add(new ListenableMap().setVarName("itemid2count"));
/*  544 */     lb.add(new ListenableMap().setVarName("type2value"));
/*  545 */     lb.add(new ListenableMap().setVarName("contentmap"));
/*  546 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SystemAwardBean {
/*      */     private Const() {}
/*      */     
/*      */     SystemAwardBean nThis() {
/*  553 */       return SystemAwardBean.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  559 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SystemAwardBean copy()
/*      */     {
/*  565 */       return SystemAwardBean.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SystemAwardBean toData()
/*      */     {
/*  571 */       return SystemAwardBean.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SystemAwardBean toBean()
/*      */     {
/*  576 */       return SystemAwardBean.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SystemAwardBean toDataIf()
/*      */     {
/*  582 */       return SystemAwardBean.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SystemAwardBean toBeanIf()
/*      */     {
/*  587 */       return SystemAwardBean.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  594 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  595 */       return SystemAwardBean.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/*  602 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  603 */       return SystemAwardBean.this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItemid2count()
/*      */     {
/*  610 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  611 */       return xdb.Consts.constMap(SystemAwardBean.this.itemid2count);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItemid2countAsData()
/*      */     {
/*  618 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  620 */       SystemAwardBean _o_ = SystemAwardBean.this;
/*  621 */       Map<Integer, Integer> itemid2count = new HashMap();
/*  622 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2count.entrySet())
/*  623 */         itemid2count.put(_e_.getKey(), _e_.getValue());
/*  624 */       return itemid2count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getType2value()
/*      */     {
/*  631 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  632 */       return xdb.Consts.constMap(SystemAwardBean.this.type2value);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getType2valueAsData()
/*      */     {
/*  639 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  641 */       SystemAwardBean _o_ = SystemAwardBean.this;
/*  642 */       Map<Integer, Integer> type2value = new HashMap();
/*  643 */       for (Map.Entry<Integer, Integer> _e_ : _o_.type2value.entrySet())
/*  644 */         type2value.put(_e_.getKey(), _e_.getValue());
/*  645 */       return type2value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getContentmap()
/*      */     {
/*  652 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  653 */       return xdb.Consts.constMap(SystemAwardBean.this.contentmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getContentmapAsData()
/*      */     {
/*  660 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*      */       
/*  662 */       SystemAwardBean _o_ = SystemAwardBean.this;
/*  663 */       Map<Integer, String> contentmap = new HashMap();
/*  664 */       for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/*  665 */         contentmap.put(_e_.getKey(), _e_.getValue());
/*  666 */       return contentmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  673 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  674 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/*  681 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  682 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  688 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  689 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  695 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  696 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  702 */       return SystemAwardBean.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  708 */       return SystemAwardBean.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  714 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  721 */       return SystemAwardBean.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  727 */       return SystemAwardBean.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  733 */       SystemAwardBean.this._xdb_verify_unsafe_();
/*  734 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  740 */       return SystemAwardBean.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  746 */       return SystemAwardBean.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  752 */       return SystemAwardBean.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  758 */       return SystemAwardBean.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  764 */       return SystemAwardBean.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  770 */       return SystemAwardBean.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  776 */       return SystemAwardBean.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SystemAwardBean
/*      */   {
/*      */     private long starttime;
/*      */     
/*      */     private long endtime;
/*      */     
/*      */     private HashMap<Integer, Integer> itemid2count;
/*      */     
/*      */     private HashMap<Integer, Integer> type2value;
/*      */     
/*      */     private HashMap<Integer, String> contentmap;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  796 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  801 */       this.starttime = 0L;
/*  802 */       this.endtime = 0L;
/*  803 */       this.itemid2count = new HashMap();
/*  804 */       this.type2value = new HashMap();
/*  805 */       this.contentmap = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.SystemAwardBean _o1_)
/*      */     {
/*  810 */       if ((_o1_ instanceof SystemAwardBean)) { assign((SystemAwardBean)_o1_);
/*  811 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  812 */       } else if ((_o1_ instanceof SystemAwardBean.Const)) assign(((SystemAwardBean.Const)_o1_).nThis()); else {
/*  813 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(SystemAwardBean _o_) {
/*  818 */       this.starttime = _o_.starttime;
/*  819 */       this.endtime = _o_.endtime;
/*  820 */       this.itemid2count = new HashMap();
/*  821 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2count.entrySet())
/*  822 */         this.itemid2count.put(_e_.getKey(), _e_.getValue());
/*  823 */       this.type2value = new HashMap();
/*  824 */       for (Map.Entry<Integer, Integer> _e_ : _o_.type2value.entrySet())
/*  825 */         this.type2value.put(_e_.getKey(), _e_.getValue());
/*  826 */       this.contentmap = new HashMap();
/*  827 */       for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet()) {
/*  828 */         this.contentmap.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  833 */       this.starttime = _o_.starttime;
/*  834 */       this.endtime = _o_.endtime;
/*  835 */       this.itemid2count = new HashMap();
/*  836 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemid2count.entrySet())
/*  837 */         this.itemid2count.put(_e_.getKey(), _e_.getValue());
/*  838 */       this.type2value = new HashMap();
/*  839 */       for (Map.Entry<Integer, Integer> _e_ : _o_.type2value.entrySet())
/*  840 */         this.type2value.put(_e_.getKey(), _e_.getValue());
/*  841 */       this.contentmap = new HashMap();
/*  842 */       for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet()) {
/*  843 */         this.contentmap.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  849 */       _os_.marshal(this.starttime);
/*  850 */       _os_.marshal(this.endtime);
/*  851 */       _os_.compact_uint32(this.itemid2count.size());
/*  852 */       for (Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet())
/*      */       {
/*  854 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  855 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  857 */       _os_.compact_uint32(this.type2value.size());
/*  858 */       for (Map.Entry<Integer, Integer> _e_ : this.type2value.entrySet())
/*      */       {
/*  860 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  861 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  863 */       _os_.compact_uint32(this.contentmap.size());
/*  864 */       for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*      */       {
/*  866 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  867 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */       }
/*  869 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  875 */       this.starttime = _os_.unmarshal_long();
/*  876 */       this.endtime = _os_.unmarshal_long();
/*      */       
/*  878 */       int size = _os_.uncompact_uint32();
/*  879 */       if (size >= 12)
/*      */       {
/*  881 */         this.itemid2count = new HashMap(size * 2);
/*      */       }
/*  883 */       for (; size > 0; size--)
/*      */       {
/*  885 */         int _k_ = 0;
/*  886 */         _k_ = _os_.unmarshal_int();
/*  887 */         int _v_ = 0;
/*  888 */         _v_ = _os_.unmarshal_int();
/*  889 */         this.itemid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  893 */       int size = _os_.uncompact_uint32();
/*  894 */       if (size >= 12)
/*      */       {
/*  896 */         this.type2value = new HashMap(size * 2);
/*      */       }
/*  898 */       for (; size > 0; size--)
/*      */       {
/*  900 */         int _k_ = 0;
/*  901 */         _k_ = _os_.unmarshal_int();
/*  902 */         int _v_ = 0;
/*  903 */         _v_ = _os_.unmarshal_int();
/*  904 */         this.type2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  908 */       int size = _os_.uncompact_uint32();
/*  909 */       if (size >= 12)
/*      */       {
/*  911 */         this.contentmap = new HashMap(size * 2);
/*      */       }
/*  913 */       for (; size > 0; size--)
/*      */       {
/*  915 */         int _k_ = 0;
/*  916 */         _k_ = _os_.unmarshal_int();
/*  917 */         String _v_ = "";
/*  918 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/*  919 */         this.contentmap.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  922 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  928 */       int _size_ = 0;
/*  929 */       _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/*  930 */       _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/*  931 */       for (Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet())
/*      */       {
/*  933 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  934 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  936 */       for (Map.Entry<Integer, Integer> _e_ : this.type2value.entrySet())
/*      */       {
/*  938 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  939 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  941 */       for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*      */       {
/*  943 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*      */         try
/*      */         {
/*  946 */           _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/*  950 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/*  953 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  961 */         _output_.writeInt64(1, this.starttime);
/*  962 */         _output_.writeInt64(2, this.endtime);
/*  963 */         for (Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet())
/*      */         {
/*  965 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  966 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  968 */         for (Map.Entry<Integer, Integer> _e_ : this.type2value.entrySet())
/*      */         {
/*  970 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  971 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  973 */         for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*      */         {
/*  975 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  976 */           _output_.writeBytes(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  981 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  983 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  991 */         boolean done = false;
/*  992 */         while (!done)
/*      */         {
/*  994 */           int tag = _input_.readTag();
/*  995 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  999 */             done = true;
/* 1000 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1004 */             this.starttime = _input_.readInt64();
/* 1005 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1009 */             this.endtime = _input_.readInt64();
/* 1010 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1014 */             int _k_ = 0;
/* 1015 */             _k_ = _input_.readInt32();
/* 1016 */             int readTag = _input_.readTag();
/* 1017 */             if (24 != readTag)
/*      */             {
/* 1019 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1021 */             int _v_ = 0;
/* 1022 */             _v_ = _input_.readInt32();
/* 1023 */             this.itemid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1024 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1028 */             int _k_ = 0;
/* 1029 */             _k_ = _input_.readInt32();
/* 1030 */             int readTag = _input_.readTag();
/* 1031 */             if (32 != readTag)
/*      */             {
/* 1033 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1035 */             int _v_ = 0;
/* 1036 */             _v_ = _input_.readInt32();
/* 1037 */             this.type2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1038 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1042 */             int _k_ = 0;
/* 1043 */             _k_ = _input_.readInt32();
/* 1044 */             int readTag = _input_.readTag();
/* 1045 */             if (42 != readTag)
/*      */             {
/* 1047 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1049 */             String _v_ = "";
/* 1050 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 1051 */             this.contentmap.put(Integer.valueOf(_k_), _v_);
/* 1052 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1056 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1058 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1067 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1071 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1073 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SystemAwardBean copy()
/*      */     {
/* 1079 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SystemAwardBean toData()
/*      */     {
/* 1085 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SystemAwardBean toBean()
/*      */     {
/* 1090 */       return new SystemAwardBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SystemAwardBean toDataIf()
/*      */     {
/* 1096 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SystemAwardBean toBeanIf()
/*      */     {
/* 1101 */       return new SystemAwardBean(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1107 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1111 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1115 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1119 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1123 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1127 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1131 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1138 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/* 1145 */       return this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItemid2count()
/*      */     {
/* 1152 */       return this.itemid2count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItemid2countAsData()
/*      */     {
/* 1159 */       return this.itemid2count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getType2value()
/*      */     {
/* 1166 */       return this.type2value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getType2valueAsData()
/*      */     {
/* 1173 */       return this.type2value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getContentmap()
/*      */     {
/* 1180 */       return this.contentmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getContentmapAsData()
/*      */     {
/* 1187 */       return this.contentmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1194 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/* 1201 */       this.endtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1207 */       if (!(_o1_ instanceof Data)) return false;
/* 1208 */       Data _o_ = (Data)_o1_;
/* 1209 */       if (this.starttime != _o_.starttime) return false;
/* 1210 */       if (this.endtime != _o_.endtime) return false;
/* 1211 */       if (!this.itemid2count.equals(_o_.itemid2count)) return false;
/* 1212 */       if (!this.type2value.equals(_o_.type2value)) return false;
/* 1213 */       if (!this.contentmap.equals(_o_.contentmap)) return false;
/* 1214 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1220 */       int _h_ = 0;
/* 1221 */       _h_ = (int)(_h_ + this.starttime);
/* 1222 */       _h_ = (int)(_h_ + this.endtime);
/* 1223 */       _h_ += this.itemid2count.hashCode();
/* 1224 */       _h_ += this.type2value.hashCode();
/* 1225 */       _h_ += this.contentmap.hashCode();
/* 1226 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1232 */       StringBuilder _sb_ = new StringBuilder();
/* 1233 */       _sb_.append("(");
/* 1234 */       _sb_.append(this.starttime);
/* 1235 */       _sb_.append(",");
/* 1236 */       _sb_.append(this.endtime);
/* 1237 */       _sb_.append(",");
/* 1238 */       _sb_.append(this.itemid2count);
/* 1239 */       _sb_.append(",");
/* 1240 */       _sb_.append(this.type2value);
/* 1241 */       _sb_.append(",");
/* 1242 */       _sb_.append(this.contentmap);
/* 1243 */       _sb_.append(")");
/* 1244 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SystemAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */