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
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class RoleGroupShoppingRecord extends XBean implements xbean.RoleGroupShoppingRecord
/*      */ {
/*      */   private HashMap<Integer, Integer> bought_num_map;
/*      */   private ArrayList<Long> participating_groups;
/*      */   private ArrayList<Long> participated_groups;
/*      */   private HashMap<Long, Integer> used_bind_yuanbao_map;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.bought_num_map.clear();
/*   25 */     this.participating_groups.clear();
/*   26 */     this.participated_groups.clear();
/*   27 */     this.used_bind_yuanbao_map.clear();
/*      */   }
/*      */   
/*      */   RoleGroupShoppingRecord(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.bought_num_map = new HashMap();
/*   34 */     this.participating_groups = new ArrayList();
/*   35 */     this.participated_groups = new ArrayList();
/*   36 */     this.used_bind_yuanbao_map = new HashMap();
/*      */   }
/*      */   
/*      */   public RoleGroupShoppingRecord()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleGroupShoppingRecord(RoleGroupShoppingRecord _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleGroupShoppingRecord(xbean.RoleGroupShoppingRecord _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof RoleGroupShoppingRecord)) { assign((RoleGroupShoppingRecord)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleGroupShoppingRecord _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.bought_num_map = new HashMap();
/*   62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.bought_num_map.entrySet())
/*   63 */       this.bought_num_map.put(_e_.getKey(), _e_.getValue());
/*   64 */     this.participating_groups = new ArrayList();
/*   65 */     this.participating_groups.addAll(_o_.participating_groups);
/*   66 */     this.participated_groups = new ArrayList();
/*   67 */     this.participated_groups.addAll(_o_.participated_groups);
/*   68 */     this.used_bind_yuanbao_map = new HashMap();
/*   69 */     for (Map.Entry<Long, Integer> _e_ : _o_.used_bind_yuanbao_map.entrySet()) {
/*   70 */       this.used_bind_yuanbao_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   75 */     this.bought_num_map = new HashMap();
/*   76 */     for (Map.Entry<Integer, Integer> _e_ : _o_.bought_num_map.entrySet())
/*   77 */       this.bought_num_map.put(_e_.getKey(), _e_.getValue());
/*   78 */     this.participating_groups = new ArrayList();
/*   79 */     this.participating_groups.addAll(_o_.participating_groups);
/*   80 */     this.participated_groups = new ArrayList();
/*   81 */     this.participated_groups.addAll(_o_.participated_groups);
/*   82 */     this.used_bind_yuanbao_map = new HashMap();
/*   83 */     for (Map.Entry<Long, Integer> _e_ : _o_.used_bind_yuanbao_map.entrySet()) {
/*   84 */       this.used_bind_yuanbao_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.compact_uint32(this.bought_num_map.size());
/*   92 */     for (Map.Entry<Integer, Integer> _e_ : this.bought_num_map.entrySet())
/*      */     {
/*   94 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   95 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   97 */     _os_.compact_uint32(this.participating_groups.size());
/*   98 */     for (Long _v_ : this.participating_groups)
/*      */     {
/*  100 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  102 */     _os_.compact_uint32(this.participated_groups.size());
/*  103 */     for (Long _v_ : this.participated_groups)
/*      */     {
/*  105 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  107 */     _os_.compact_uint32(this.used_bind_yuanbao_map.size());
/*  108 */     for (Map.Entry<Long, Integer> _e_ : this.used_bind_yuanbao_map.entrySet())
/*      */     {
/*  110 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  111 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*      */     
/*  121 */     int size = _os_.uncompact_uint32();
/*  122 */     if (size >= 12)
/*      */     {
/*  124 */       this.bought_num_map = new HashMap(size * 2);
/*      */     }
/*  126 */     for (; size > 0; size--)
/*      */     {
/*  128 */       int _k_ = 0;
/*  129 */       _k_ = _os_.unmarshal_int();
/*  130 */       int _v_ = 0;
/*  131 */       _v_ = _os_.unmarshal_int();
/*  132 */       this.bought_num_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  135 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  137 */       long _v_ = 0L;
/*  138 */       _v_ = _os_.unmarshal_long();
/*  139 */       this.participating_groups.add(Long.valueOf(_v_));
/*      */     }
/*  141 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  143 */       long _v_ = 0L;
/*  144 */       _v_ = _os_.unmarshal_long();
/*  145 */       this.participated_groups.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  148 */     int size = _os_.uncompact_uint32();
/*  149 */     if (size >= 12)
/*      */     {
/*  151 */       this.used_bind_yuanbao_map = new HashMap(size * 2);
/*      */     }
/*  153 */     for (; size > 0; size--)
/*      */     {
/*  155 */       long _k_ = 0L;
/*  156 */       _k_ = _os_.unmarshal_long();
/*  157 */       int _v_ = 0;
/*  158 */       _v_ = _os_.unmarshal_int();
/*  159 */       this.used_bind_yuanbao_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
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
/*  170 */     for (Map.Entry<Integer, Integer> _e_ : this.bought_num_map.entrySet())
/*      */     {
/*  172 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  173 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  175 */     for (Long _v_ : this.participating_groups)
/*      */     {
/*  177 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  179 */     for (Long _v_ : this.participated_groups)
/*      */     {
/*  181 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  183 */     for (Map.Entry<Long, Integer> _e_ : this.used_bind_yuanbao_map.entrySet())
/*      */     {
/*  185 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  186 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  188 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  194 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  197 */       for (Map.Entry<Integer, Integer> _e_ : this.bought_num_map.entrySet())
/*      */       {
/*  199 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  200 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  202 */       for (Long _v_ : this.participating_groups)
/*      */       {
/*  204 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  206 */       for (Long _v_ : this.participated_groups)
/*      */       {
/*  208 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  210 */       for (Map.Entry<Long, Integer> _e_ : this.used_bind_yuanbao_map.entrySet())
/*      */       {
/*  212 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  213 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  220 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  229 */       boolean done = false;
/*  230 */       while (!done)
/*      */       {
/*  232 */         int tag = _input_.readTag();
/*  233 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  237 */           done = true;
/*  238 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  242 */           int _k_ = 0;
/*  243 */           _k_ = _input_.readInt32();
/*  244 */           int readTag = _input_.readTag();
/*  245 */           if (8 != readTag)
/*      */           {
/*  247 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  249 */           int _v_ = 0;
/*  250 */           _v_ = _input_.readInt32();
/*  251 */           this.bought_num_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  256 */           long _v_ = 0L;
/*  257 */           _v_ = _input_.readInt64();
/*  258 */           this.participating_groups.add(Long.valueOf(_v_));
/*  259 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  263 */           long _v_ = 0L;
/*  264 */           _v_ = _input_.readInt64();
/*  265 */           this.participated_groups.add(Long.valueOf(_v_));
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  270 */           long _k_ = 0L;
/*  271 */           _k_ = _input_.readInt64();
/*  272 */           int readTag = _input_.readTag();
/*  273 */           if (32 != readTag)
/*      */           {
/*  275 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  277 */           int _v_ = 0;
/*  278 */           _v_ = _input_.readInt32();
/*  279 */           this.used_bind_yuanbao_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  280 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  284 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  286 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  295 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  299 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  301 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleGroupShoppingRecord copy()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new RoleGroupShoppingRecord(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleGroupShoppingRecord toData()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleGroupShoppingRecord toBean()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return new RoleGroupShoppingRecord(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleGroupShoppingRecord toDataIf()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleGroupShoppingRecord toBeanIf()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*  334 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBought_num_map()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return xdb.Logs.logMap(new xdb.LogKey(this, "bought_num_map"), this.bought_num_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBought_num_mapAsData()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*      */     
/*  358 */     RoleGroupShoppingRecord _o_ = this;
/*  359 */     Map<Integer, Integer> bought_num_map = new HashMap();
/*  360 */     for (Map.Entry<Integer, Integer> _e_ : _o_.bought_num_map.entrySet())
/*  361 */       bought_num_map.put(_e_.getKey(), _e_.getValue());
/*  362 */     return bought_num_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getParticipating_groups()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return xdb.Logs.logList(new xdb.LogKey(this, "participating_groups"), this.participating_groups);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getParticipating_groupsAsData()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*      */     
/*  378 */     RoleGroupShoppingRecord _o_ = this;
/*  379 */     List<Long> participating_groups = new ArrayList();
/*  380 */     participating_groups.addAll(_o_.participating_groups);
/*  381 */     return participating_groups;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getParticipated_groups()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return xdb.Logs.logList(new xdb.LogKey(this, "participated_groups"), this.participated_groups);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getParticipated_groupsAsData()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*      */     
/*  397 */     RoleGroupShoppingRecord _o_ = this;
/*  398 */     List<Long> participated_groups = new ArrayList();
/*  399 */     participated_groups.addAll(_o_.participated_groups);
/*  400 */     return participated_groups;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getUsed_bind_yuanbao_map()
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     return xdb.Logs.logMap(new xdb.LogKey(this, "used_bind_yuanbao_map"), this.used_bind_yuanbao_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getUsed_bind_yuanbao_mapAsData()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*      */     
/*  417 */     RoleGroupShoppingRecord _o_ = this;
/*  418 */     Map<Long, Integer> used_bind_yuanbao_map = new HashMap();
/*  419 */     for (Map.Entry<Long, Integer> _e_ : _o_.used_bind_yuanbao_map.entrySet())
/*  420 */       used_bind_yuanbao_map.put(_e_.getKey(), _e_.getValue());
/*  421 */     return used_bind_yuanbao_map;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     RoleGroupShoppingRecord _o_ = null;
/*  429 */     if ((_o1_ instanceof RoleGroupShoppingRecord)) { _o_ = (RoleGroupShoppingRecord)_o1_;
/*  430 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  431 */       return false;
/*  432 */     if (!this.bought_num_map.equals(_o_.bought_num_map)) return false;
/*  433 */     if (!this.participating_groups.equals(_o_.participating_groups)) return false;
/*  434 */     if (!this.participated_groups.equals(_o_.participated_groups)) return false;
/*  435 */     if (!this.used_bind_yuanbao_map.equals(_o_.used_bind_yuanbao_map)) return false;
/*  436 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     int _h_ = 0;
/*  444 */     _h_ += this.bought_num_map.hashCode();
/*  445 */     _h_ += this.participating_groups.hashCode();
/*  446 */     _h_ += this.participated_groups.hashCode();
/*  447 */     _h_ += this.used_bind_yuanbao_map.hashCode();
/*  448 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  454 */     _xdb_verify_unsafe_();
/*  455 */     StringBuilder _sb_ = new StringBuilder();
/*  456 */     _sb_.append("(");
/*  457 */     _sb_.append(this.bought_num_map);
/*  458 */     _sb_.append(",");
/*  459 */     _sb_.append(this.participating_groups);
/*  460 */     _sb_.append(",");
/*  461 */     _sb_.append(this.participated_groups);
/*  462 */     _sb_.append(",");
/*  463 */     _sb_.append(this.used_bind_yuanbao_map);
/*  464 */     _sb_.append(")");
/*  465 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  471 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  472 */     lb.add(new xdb.logs.ListenableMap().setVarName("bought_num_map"));
/*  473 */     lb.add(new xdb.logs.ListenableChanged().setVarName("participating_groups"));
/*  474 */     lb.add(new xdb.logs.ListenableChanged().setVarName("participated_groups"));
/*  475 */     lb.add(new xdb.logs.ListenableMap().setVarName("used_bind_yuanbao_map"));
/*  476 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleGroupShoppingRecord {
/*      */     private Const() {}
/*      */     
/*      */     RoleGroupShoppingRecord nThis() {
/*  483 */       return RoleGroupShoppingRecord.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  489 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGroupShoppingRecord copy()
/*      */     {
/*  495 */       return RoleGroupShoppingRecord.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGroupShoppingRecord toData()
/*      */     {
/*  501 */       return RoleGroupShoppingRecord.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleGroupShoppingRecord toBean()
/*      */     {
/*  506 */       return RoleGroupShoppingRecord.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGroupShoppingRecord toDataIf()
/*      */     {
/*  512 */       return RoleGroupShoppingRecord.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleGroupShoppingRecord toBeanIf()
/*      */     {
/*  517 */       return RoleGroupShoppingRecord.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBought_num_map()
/*      */     {
/*  524 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  525 */       return xdb.Consts.constMap(RoleGroupShoppingRecord.this.bought_num_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBought_num_mapAsData()
/*      */     {
/*  532 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*      */       
/*  534 */       RoleGroupShoppingRecord _o_ = RoleGroupShoppingRecord.this;
/*  535 */       Map<Integer, Integer> bought_num_map = new HashMap();
/*  536 */       for (Map.Entry<Integer, Integer> _e_ : _o_.bought_num_map.entrySet())
/*  537 */         bought_num_map.put(_e_.getKey(), _e_.getValue());
/*  538 */       return bought_num_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipating_groups()
/*      */     {
/*  545 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  546 */       return xdb.Consts.constList(RoleGroupShoppingRecord.this.participating_groups);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getParticipating_groupsAsData()
/*      */     {
/*  552 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*      */       
/*  554 */       RoleGroupShoppingRecord _o_ = RoleGroupShoppingRecord.this;
/*  555 */       List<Long> participating_groups = new ArrayList();
/*  556 */       participating_groups.addAll(_o_.participating_groups);
/*  557 */       return participating_groups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipated_groups()
/*      */     {
/*  564 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  565 */       return xdb.Consts.constList(RoleGroupShoppingRecord.this.participated_groups);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getParticipated_groupsAsData()
/*      */     {
/*  571 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*      */       
/*  573 */       RoleGroupShoppingRecord _o_ = RoleGroupShoppingRecord.this;
/*  574 */       List<Long> participated_groups = new ArrayList();
/*  575 */       participated_groups.addAll(_o_.participated_groups);
/*  576 */       return participated_groups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getUsed_bind_yuanbao_map()
/*      */     {
/*  583 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  584 */       return xdb.Consts.constMap(RoleGroupShoppingRecord.this.used_bind_yuanbao_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getUsed_bind_yuanbao_mapAsData()
/*      */     {
/*  591 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*      */       
/*  593 */       RoleGroupShoppingRecord _o_ = RoleGroupShoppingRecord.this;
/*  594 */       Map<Long, Integer> used_bind_yuanbao_map = new HashMap();
/*  595 */       for (Map.Entry<Long, Integer> _e_ : _o_.used_bind_yuanbao_map.entrySet())
/*  596 */         used_bind_yuanbao_map.put(_e_.getKey(), _e_.getValue());
/*  597 */       return used_bind_yuanbao_map;
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  603 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  604 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  610 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  611 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  617 */       return RoleGroupShoppingRecord.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  623 */       return RoleGroupShoppingRecord.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  629 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  636 */       return RoleGroupShoppingRecord.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  642 */       return RoleGroupShoppingRecord.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  648 */       RoleGroupShoppingRecord.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  655 */       return RoleGroupShoppingRecord.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  661 */       return RoleGroupShoppingRecord.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  667 */       return RoleGroupShoppingRecord.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  673 */       return RoleGroupShoppingRecord.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  679 */       return RoleGroupShoppingRecord.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  685 */       return RoleGroupShoppingRecord.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  691 */       return RoleGroupShoppingRecord.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleGroupShoppingRecord
/*      */   {
/*      */     private HashMap<Integer, Integer> bought_num_map;
/*      */     
/*      */     private ArrayList<Long> participating_groups;
/*      */     
/*      */     private ArrayList<Long> participated_groups;
/*      */     
/*      */     private HashMap<Long, Integer> used_bind_yuanbao_map;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  709 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  714 */       this.bought_num_map = new HashMap();
/*  715 */       this.participating_groups = new ArrayList();
/*  716 */       this.participated_groups = new ArrayList();
/*  717 */       this.used_bind_yuanbao_map = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleGroupShoppingRecord _o1_)
/*      */     {
/*  722 */       if ((_o1_ instanceof RoleGroupShoppingRecord)) { assign((RoleGroupShoppingRecord)_o1_);
/*  723 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  724 */       } else if ((_o1_ instanceof RoleGroupShoppingRecord.Const)) assign(((RoleGroupShoppingRecord.Const)_o1_).nThis()); else {
/*  725 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleGroupShoppingRecord _o_) {
/*  730 */       this.bought_num_map = new HashMap();
/*  731 */       for (Map.Entry<Integer, Integer> _e_ : _o_.bought_num_map.entrySet())
/*  732 */         this.bought_num_map.put(_e_.getKey(), _e_.getValue());
/*  733 */       this.participating_groups = new ArrayList();
/*  734 */       this.participating_groups.addAll(_o_.participating_groups);
/*  735 */       this.participated_groups = new ArrayList();
/*  736 */       this.participated_groups.addAll(_o_.participated_groups);
/*  737 */       this.used_bind_yuanbao_map = new HashMap();
/*  738 */       for (Map.Entry<Long, Integer> _e_ : _o_.used_bind_yuanbao_map.entrySet()) {
/*  739 */         this.used_bind_yuanbao_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  744 */       this.bought_num_map = new HashMap();
/*  745 */       for (Map.Entry<Integer, Integer> _e_ : _o_.bought_num_map.entrySet())
/*  746 */         this.bought_num_map.put(_e_.getKey(), _e_.getValue());
/*  747 */       this.participating_groups = new ArrayList();
/*  748 */       this.participating_groups.addAll(_o_.participating_groups);
/*  749 */       this.participated_groups = new ArrayList();
/*  750 */       this.participated_groups.addAll(_o_.participated_groups);
/*  751 */       this.used_bind_yuanbao_map = new HashMap();
/*  752 */       for (Map.Entry<Long, Integer> _e_ : _o_.used_bind_yuanbao_map.entrySet()) {
/*  753 */         this.used_bind_yuanbao_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  759 */       _os_.compact_uint32(this.bought_num_map.size());
/*  760 */       for (Map.Entry<Integer, Integer> _e_ : this.bought_num_map.entrySet())
/*      */       {
/*  762 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  763 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  765 */       _os_.compact_uint32(this.participating_groups.size());
/*  766 */       for (Long _v_ : this.participating_groups)
/*      */       {
/*  768 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  770 */       _os_.compact_uint32(this.participated_groups.size());
/*  771 */       for (Long _v_ : this.participated_groups)
/*      */       {
/*  773 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  775 */       _os_.compact_uint32(this.used_bind_yuanbao_map.size());
/*  776 */       for (Map.Entry<Long, Integer> _e_ : this.used_bind_yuanbao_map.entrySet())
/*      */       {
/*  778 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  779 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  781 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  788 */       int size = _os_.uncompact_uint32();
/*  789 */       if (size >= 12)
/*      */       {
/*  791 */         this.bought_num_map = new HashMap(size * 2);
/*      */       }
/*  793 */       for (; size > 0; size--)
/*      */       {
/*  795 */         int _k_ = 0;
/*  796 */         _k_ = _os_.unmarshal_int();
/*  797 */         int _v_ = 0;
/*  798 */         _v_ = _os_.unmarshal_int();
/*  799 */         this.bought_num_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  802 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  804 */         long _v_ = 0L;
/*  805 */         _v_ = _os_.unmarshal_long();
/*  806 */         this.participating_groups.add(Long.valueOf(_v_));
/*      */       }
/*  808 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  810 */         long _v_ = 0L;
/*  811 */         _v_ = _os_.unmarshal_long();
/*  812 */         this.participated_groups.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  815 */       int size = _os_.uncompact_uint32();
/*  816 */       if (size >= 12)
/*      */       {
/*  818 */         this.used_bind_yuanbao_map = new HashMap(size * 2);
/*      */       }
/*  820 */       for (; size > 0; size--)
/*      */       {
/*  822 */         long _k_ = 0L;
/*  823 */         _k_ = _os_.unmarshal_long();
/*  824 */         int _v_ = 0;
/*  825 */         _v_ = _os_.unmarshal_int();
/*  826 */         this.used_bind_yuanbao_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  829 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  835 */       int _size_ = 0;
/*  836 */       for (Map.Entry<Integer, Integer> _e_ : this.bought_num_map.entrySet())
/*      */       {
/*  838 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  839 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  841 */       for (Long _v_ : this.participating_groups)
/*      */       {
/*  843 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/*  845 */       for (Long _v_ : this.participated_groups)
/*      */       {
/*  847 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/*  849 */       for (Map.Entry<Long, Integer> _e_ : this.used_bind_yuanbao_map.entrySet())
/*      */       {
/*  851 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  852 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  854 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  862 */         for (Map.Entry<Integer, Integer> _e_ : this.bought_num_map.entrySet())
/*      */         {
/*  864 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  865 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  867 */         for (Long _v_ : this.participating_groups)
/*      */         {
/*  869 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/*  871 */         for (Long _v_ : this.participated_groups)
/*      */         {
/*  873 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/*  875 */         for (Map.Entry<Long, Integer> _e_ : this.used_bind_yuanbao_map.entrySet())
/*      */         {
/*  877 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  878 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  883 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  885 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  893 */         boolean done = false;
/*  894 */         while (!done)
/*      */         {
/*  896 */           int tag = _input_.readTag();
/*  897 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  901 */             done = true;
/*  902 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  906 */             int _k_ = 0;
/*  907 */             _k_ = _input_.readInt32();
/*  908 */             int readTag = _input_.readTag();
/*  909 */             if (8 != readTag)
/*      */             {
/*  911 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  913 */             int _v_ = 0;
/*  914 */             _v_ = _input_.readInt32();
/*  915 */             this.bought_num_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  920 */             long _v_ = 0L;
/*  921 */             _v_ = _input_.readInt64();
/*  922 */             this.participating_groups.add(Long.valueOf(_v_));
/*  923 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  927 */             long _v_ = 0L;
/*  928 */             _v_ = _input_.readInt64();
/*  929 */             this.participated_groups.add(Long.valueOf(_v_));
/*  930 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  934 */             long _k_ = 0L;
/*  935 */             _k_ = _input_.readInt64();
/*  936 */             int readTag = _input_.readTag();
/*  937 */             if (32 != readTag)
/*      */             {
/*  939 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  941 */             int _v_ = 0;
/*  942 */             _v_ = _input_.readInt32();
/*  943 */             this.used_bind_yuanbao_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  944 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  948 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  950 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  959 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  963 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  965 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGroupShoppingRecord copy()
/*      */     {
/*  971 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGroupShoppingRecord toData()
/*      */     {
/*  977 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleGroupShoppingRecord toBean()
/*      */     {
/*  982 */       return new RoleGroupShoppingRecord(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleGroupShoppingRecord toDataIf()
/*      */     {
/*  988 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleGroupShoppingRecord toBeanIf()
/*      */     {
/*  993 */       return new RoleGroupShoppingRecord(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  999 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1003 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1007 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1011 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1015 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1019 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1023 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBought_num_map()
/*      */     {
/* 1030 */       return this.bought_num_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBought_num_mapAsData()
/*      */     {
/* 1037 */       return this.bought_num_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipating_groups()
/*      */     {
/* 1044 */       return this.participating_groups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipating_groupsAsData()
/*      */     {
/* 1051 */       return this.participating_groups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipated_groups()
/*      */     {
/* 1058 */       return this.participated_groups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipated_groupsAsData()
/*      */     {
/* 1065 */       return this.participated_groups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getUsed_bind_yuanbao_map()
/*      */     {
/* 1072 */       return this.used_bind_yuanbao_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getUsed_bind_yuanbao_mapAsData()
/*      */     {
/* 1079 */       return this.used_bind_yuanbao_map;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1085 */       if (!(_o1_ instanceof Data)) return false;
/* 1086 */       Data _o_ = (Data)_o1_;
/* 1087 */       if (!this.bought_num_map.equals(_o_.bought_num_map)) return false;
/* 1088 */       if (!this.participating_groups.equals(_o_.participating_groups)) return false;
/* 1089 */       if (!this.participated_groups.equals(_o_.participated_groups)) return false;
/* 1090 */       if (!this.used_bind_yuanbao_map.equals(_o_.used_bind_yuanbao_map)) return false;
/* 1091 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1097 */       int _h_ = 0;
/* 1098 */       _h_ += this.bought_num_map.hashCode();
/* 1099 */       _h_ += this.participating_groups.hashCode();
/* 1100 */       _h_ += this.participated_groups.hashCode();
/* 1101 */       _h_ += this.used_bind_yuanbao_map.hashCode();
/* 1102 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1108 */       StringBuilder _sb_ = new StringBuilder();
/* 1109 */       _sb_.append("(");
/* 1110 */       _sb_.append(this.bought_num_map);
/* 1111 */       _sb_.append(",");
/* 1112 */       _sb_.append(this.participating_groups);
/* 1113 */       _sb_.append(",");
/* 1114 */       _sb_.append(this.participated_groups);
/* 1115 */       _sb_.append(",");
/* 1116 */       _sb_.append(this.used_bind_yuanbao_map);
/* 1117 */       _sb_.append(")");
/* 1118 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleGroupShoppingRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */