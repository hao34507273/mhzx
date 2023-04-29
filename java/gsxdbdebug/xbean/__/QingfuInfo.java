/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class QingfuInfo
/*      */   extends XBean
/*      */   implements xbean.QingfuInfo
/*      */ {
/*      */   private String appid;
/*      */   private long save_amt;
/*      */   private long total_cash;
/*      */   private long total_cost;
/*      */   private long total_cost_bind;
/*      */   private long total_present;
/*      */   private long total_present_bind;
/*      */   private long total_confirm_cost;
/*      */   private long total_confirm_cost_bind;
/*      */   private long total_confirm_present;
/*      */   private long total_confirm_present_bind;
/*      */   private String tss_list;
/*      */   private HashMap<String, xbean.TssSumInfo> tss_sum_map;
/*      */   private int first_recharge_status;
/*      */   private int recharge_times;
/*      */   private int statis_recharge_first_consume_status;
/*      */   private HashMap<Integer, xbean.SaveAmtActivityInfo> save_amt_activity_infos;
/*      */   private HashMap<Integer, xbean.LevelGrowthFundActivityInfo> level_growth_fund_activity_infos;
/*      */   private HashMap<Integer, xbean.MonthCardActivityInfo> moth_card_activity_infos;
/*      */   private HashMap<Integer, xbean.AccumTotalCostActivityInfo> accum_total_cost_activity_infos;
/*      */   private HashMap<Integer, xbean.RMBGiftBagActivityInfo> rmb_gift_bag_activity_infos;
/*      */   private xbean.RecentlyCashInfo recently_cash_infos;
/*      */   private long total_cash_amt;
/*      */   private long inner_save_amt;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   64 */     this.appid = "";
/*   65 */     this.save_amt = 0L;
/*   66 */     this.total_cash = 0L;
/*   67 */     this.total_cost = 0L;
/*   68 */     this.total_cost_bind = 0L;
/*   69 */     this.total_present = 0L;
/*   70 */     this.total_present_bind = 0L;
/*   71 */     this.total_confirm_cost = 0L;
/*   72 */     this.total_confirm_cost_bind = 0L;
/*   73 */     this.total_confirm_present = 0L;
/*   74 */     this.total_confirm_present_bind = 0L;
/*   75 */     this.tss_list = "";
/*   76 */     this.tss_sum_map.clear();
/*   77 */     this.first_recharge_status = 1;
/*   78 */     this.recharge_times = 0;
/*   79 */     this.statis_recharge_first_consume_status = 0;
/*   80 */     this.save_amt_activity_infos.clear();
/*   81 */     this.level_growth_fund_activity_infos.clear();
/*   82 */     this.moth_card_activity_infos.clear();
/*   83 */     this.accum_total_cost_activity_infos.clear();
/*   84 */     this.rmb_gift_bag_activity_infos.clear();
/*   85 */     this.recently_cash_infos._reset_unsafe_();
/*   86 */     this.total_cash_amt = 0L;
/*   87 */     this.inner_save_amt = 0L;
/*      */   }
/*      */   
/*      */   QingfuInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   92 */     super(_xp_, _vn_);
/*   93 */     this.appid = "";
/*   94 */     this.save_amt = 0L;
/*   95 */     this.total_cash = 0L;
/*   96 */     this.total_cost = 0L;
/*   97 */     this.total_cost_bind = 0L;
/*   98 */     this.total_present = 0L;
/*   99 */     this.total_present_bind = 0L;
/*  100 */     this.total_confirm_cost = 0L;
/*  101 */     this.total_confirm_cost_bind = 0L;
/*  102 */     this.total_confirm_present = 0L;
/*  103 */     this.total_confirm_present_bind = 0L;
/*  104 */     this.tss_list = "";
/*  105 */     this.tss_sum_map = new HashMap();
/*  106 */     this.first_recharge_status = 1;
/*  107 */     this.recharge_times = 0;
/*  108 */     this.statis_recharge_first_consume_status = 0;
/*  109 */     this.save_amt_activity_infos = new HashMap();
/*  110 */     this.level_growth_fund_activity_infos = new HashMap();
/*  111 */     this.moth_card_activity_infos = new HashMap();
/*  112 */     this.accum_total_cost_activity_infos = new HashMap();
/*  113 */     this.rmb_gift_bag_activity_infos = new HashMap();
/*  114 */     this.recently_cash_infos = new RecentlyCashInfo(0, this, "recently_cash_infos");
/*  115 */     this.total_cash_amt = 0L;
/*  116 */     this.inner_save_amt = 0L;
/*      */   }
/*      */   
/*      */   public QingfuInfo()
/*      */   {
/*  121 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public QingfuInfo(QingfuInfo _o_)
/*      */   {
/*  126 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   QingfuInfo(xbean.QingfuInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  131 */     super(_xp_, _vn_);
/*  132 */     if ((_o1_ instanceof QingfuInfo)) { assign((QingfuInfo)_o1_);
/*  133 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  134 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  135 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(QingfuInfo _o_) {
/*  140 */     _o_._xdb_verify_unsafe_();
/*  141 */     this.appid = _o_.appid;
/*  142 */     this.save_amt = _o_.save_amt;
/*  143 */     this.total_cash = _o_.total_cash;
/*  144 */     this.total_cost = _o_.total_cost;
/*  145 */     this.total_cost_bind = _o_.total_cost_bind;
/*  146 */     this.total_present = _o_.total_present;
/*  147 */     this.total_present_bind = _o_.total_present_bind;
/*  148 */     this.total_confirm_cost = _o_.total_confirm_cost;
/*  149 */     this.total_confirm_cost_bind = _o_.total_confirm_cost_bind;
/*  150 */     this.total_confirm_present = _o_.total_confirm_present;
/*  151 */     this.total_confirm_present_bind = _o_.total_confirm_present_bind;
/*  152 */     this.tss_list = _o_.tss_list;
/*  153 */     this.tss_sum_map = new HashMap();
/*  154 */     for (Map.Entry<String, xbean.TssSumInfo> _e_ : _o_.tss_sum_map.entrySet())
/*  155 */       this.tss_sum_map.put(_e_.getKey(), new TssSumInfo((xbean.TssSumInfo)_e_.getValue(), this, "tss_sum_map"));
/*  156 */     this.first_recharge_status = _o_.first_recharge_status;
/*  157 */     this.recharge_times = _o_.recharge_times;
/*  158 */     this.statis_recharge_first_consume_status = _o_.statis_recharge_first_consume_status;
/*  159 */     this.save_amt_activity_infos = new HashMap();
/*  160 */     for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : _o_.save_amt_activity_infos.entrySet())
/*  161 */       this.save_amt_activity_infos.put(_e_.getKey(), new SaveAmtActivityInfo((xbean.SaveAmtActivityInfo)_e_.getValue(), this, "save_amt_activity_infos"));
/*  162 */     this.level_growth_fund_activity_infos = new HashMap();
/*  163 */     for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : _o_.level_growth_fund_activity_infos.entrySet())
/*  164 */       this.level_growth_fund_activity_infos.put(_e_.getKey(), new LevelGrowthFundActivityInfo((xbean.LevelGrowthFundActivityInfo)_e_.getValue(), this, "level_growth_fund_activity_infos"));
/*  165 */     this.moth_card_activity_infos = new HashMap();
/*  166 */     for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : _o_.moth_card_activity_infos.entrySet())
/*  167 */       this.moth_card_activity_infos.put(_e_.getKey(), new MonthCardActivityInfo((xbean.MonthCardActivityInfo)_e_.getValue(), this, "moth_card_activity_infos"));
/*  168 */     this.accum_total_cost_activity_infos = new HashMap();
/*  169 */     for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : _o_.accum_total_cost_activity_infos.entrySet())
/*  170 */       this.accum_total_cost_activity_infos.put(_e_.getKey(), new AccumTotalCostActivityInfo((xbean.AccumTotalCostActivityInfo)_e_.getValue(), this, "accum_total_cost_activity_infos"));
/*  171 */     this.rmb_gift_bag_activity_infos = new HashMap();
/*  172 */     for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : _o_.rmb_gift_bag_activity_infos.entrySet())
/*  173 */       this.rmb_gift_bag_activity_infos.put(_e_.getKey(), new RMBGiftBagActivityInfo((xbean.RMBGiftBagActivityInfo)_e_.getValue(), this, "rmb_gift_bag_activity_infos"));
/*  174 */     this.recently_cash_infos = new RecentlyCashInfo(_o_.recently_cash_infos, this, "recently_cash_infos");
/*  175 */     this.total_cash_amt = _o_.total_cash_amt;
/*  176 */     this.inner_save_amt = _o_.inner_save_amt;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  181 */     this.appid = _o_.appid;
/*  182 */     this.save_amt = _o_.save_amt;
/*  183 */     this.total_cash = _o_.total_cash;
/*  184 */     this.total_cost = _o_.total_cost;
/*  185 */     this.total_cost_bind = _o_.total_cost_bind;
/*  186 */     this.total_present = _o_.total_present;
/*  187 */     this.total_present_bind = _o_.total_present_bind;
/*  188 */     this.total_confirm_cost = _o_.total_confirm_cost;
/*  189 */     this.total_confirm_cost_bind = _o_.total_confirm_cost_bind;
/*  190 */     this.total_confirm_present = _o_.total_confirm_present;
/*  191 */     this.total_confirm_present_bind = _o_.total_confirm_present_bind;
/*  192 */     this.tss_list = _o_.tss_list;
/*  193 */     this.tss_sum_map = new HashMap();
/*  194 */     for (Map.Entry<String, xbean.TssSumInfo> _e_ : _o_.tss_sum_map.entrySet())
/*  195 */       this.tss_sum_map.put(_e_.getKey(), new TssSumInfo((xbean.TssSumInfo)_e_.getValue(), this, "tss_sum_map"));
/*  196 */     this.first_recharge_status = _o_.first_recharge_status;
/*  197 */     this.recharge_times = _o_.recharge_times;
/*  198 */     this.statis_recharge_first_consume_status = _o_.statis_recharge_first_consume_status;
/*  199 */     this.save_amt_activity_infos = new HashMap();
/*  200 */     for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : _o_.save_amt_activity_infos.entrySet())
/*  201 */       this.save_amt_activity_infos.put(_e_.getKey(), new SaveAmtActivityInfo((xbean.SaveAmtActivityInfo)_e_.getValue(), this, "save_amt_activity_infos"));
/*  202 */     this.level_growth_fund_activity_infos = new HashMap();
/*  203 */     for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : _o_.level_growth_fund_activity_infos.entrySet())
/*  204 */       this.level_growth_fund_activity_infos.put(_e_.getKey(), new LevelGrowthFundActivityInfo((xbean.LevelGrowthFundActivityInfo)_e_.getValue(), this, "level_growth_fund_activity_infos"));
/*  205 */     this.moth_card_activity_infos = new HashMap();
/*  206 */     for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : _o_.moth_card_activity_infos.entrySet())
/*  207 */       this.moth_card_activity_infos.put(_e_.getKey(), new MonthCardActivityInfo((xbean.MonthCardActivityInfo)_e_.getValue(), this, "moth_card_activity_infos"));
/*  208 */     this.accum_total_cost_activity_infos = new HashMap();
/*  209 */     for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : _o_.accum_total_cost_activity_infos.entrySet())
/*  210 */       this.accum_total_cost_activity_infos.put(_e_.getKey(), new AccumTotalCostActivityInfo((xbean.AccumTotalCostActivityInfo)_e_.getValue(), this, "accum_total_cost_activity_infos"));
/*  211 */     this.rmb_gift_bag_activity_infos = new HashMap();
/*  212 */     for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : _o_.rmb_gift_bag_activity_infos.entrySet())
/*  213 */       this.rmb_gift_bag_activity_infos.put(_e_.getKey(), new RMBGiftBagActivityInfo((xbean.RMBGiftBagActivityInfo)_e_.getValue(), this, "rmb_gift_bag_activity_infos"));
/*  214 */     this.recently_cash_infos = new RecentlyCashInfo(_o_.recently_cash_infos, this, "recently_cash_infos");
/*  215 */     this.total_cash_amt = _o_.total_cash_amt;
/*  216 */     this.inner_save_amt = _o_.inner_save_amt;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*  223 */     _os_.marshal(this.appid, "UTF-16LE");
/*  224 */     _os_.marshal(this.save_amt);
/*  225 */     _os_.marshal(this.total_cash);
/*  226 */     _os_.marshal(this.total_cost);
/*  227 */     _os_.marshal(this.total_cost_bind);
/*  228 */     _os_.marshal(this.total_present);
/*  229 */     _os_.marshal(this.total_present_bind);
/*  230 */     _os_.marshal(this.total_confirm_cost);
/*  231 */     _os_.marshal(this.total_confirm_cost_bind);
/*  232 */     _os_.marshal(this.total_confirm_present);
/*  233 */     _os_.marshal(this.total_confirm_present_bind);
/*  234 */     _os_.marshal(this.tss_list, "UTF-16LE");
/*  235 */     _os_.compact_uint32(this.tss_sum_map.size());
/*  236 */     for (Map.Entry<String, xbean.TssSumInfo> _e_ : this.tss_sum_map.entrySet())
/*      */     {
/*  238 */       _os_.marshal((String)_e_.getKey(), "UTF-16LE");
/*  239 */       ((xbean.TssSumInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  241 */     _os_.marshal(this.first_recharge_status);
/*  242 */     _os_.marshal(this.recharge_times);
/*  243 */     _os_.marshal(this.statis_recharge_first_consume_status);
/*  244 */     _os_.compact_uint32(this.save_amt_activity_infos.size());
/*  245 */     for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : this.save_amt_activity_infos.entrySet())
/*      */     {
/*  247 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  248 */       ((xbean.SaveAmtActivityInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  250 */     _os_.compact_uint32(this.level_growth_fund_activity_infos.size());
/*  251 */     for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : this.level_growth_fund_activity_infos.entrySet())
/*      */     {
/*  253 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  254 */       ((xbean.LevelGrowthFundActivityInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  256 */     _os_.compact_uint32(this.moth_card_activity_infos.size());
/*  257 */     for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : this.moth_card_activity_infos.entrySet())
/*      */     {
/*  259 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  260 */       ((xbean.MonthCardActivityInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  262 */     _os_.compact_uint32(this.accum_total_cost_activity_infos.size());
/*  263 */     for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : this.accum_total_cost_activity_infos.entrySet())
/*      */     {
/*  265 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  266 */       ((xbean.AccumTotalCostActivityInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  268 */     _os_.compact_uint32(this.rmb_gift_bag_activity_infos.size());
/*  269 */     for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : this.rmb_gift_bag_activity_infos.entrySet())
/*      */     {
/*  271 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  272 */       ((xbean.RMBGiftBagActivityInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  274 */     this.recently_cash_infos.marshal(_os_);
/*  275 */     _os_.marshal(this.total_cash_amt);
/*  276 */     _os_.marshal(this.inner_save_amt);
/*  277 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     this.appid = _os_.unmarshal_String("UTF-16LE");
/*  285 */     this.save_amt = _os_.unmarshal_long();
/*  286 */     this.total_cash = _os_.unmarshal_long();
/*  287 */     this.total_cost = _os_.unmarshal_long();
/*  288 */     this.total_cost_bind = _os_.unmarshal_long();
/*  289 */     this.total_present = _os_.unmarshal_long();
/*  290 */     this.total_present_bind = _os_.unmarshal_long();
/*  291 */     this.total_confirm_cost = _os_.unmarshal_long();
/*  292 */     this.total_confirm_cost_bind = _os_.unmarshal_long();
/*  293 */     this.total_confirm_present = _os_.unmarshal_long();
/*  294 */     this.total_confirm_present_bind = _os_.unmarshal_long();
/*  295 */     this.tss_list = _os_.unmarshal_String("UTF-16LE");
/*      */     
/*  297 */     int size = _os_.uncompact_uint32();
/*  298 */     if (size >= 12)
/*      */     {
/*  300 */       this.tss_sum_map = new HashMap(size * 2);
/*      */     }
/*  302 */     for (; size > 0; size--)
/*      */     {
/*  304 */       String _k_ = "";
/*  305 */       _k_ = _os_.unmarshal_String("UTF-16LE");
/*  306 */       xbean.TssSumInfo _v_ = new TssSumInfo(0, this, "tss_sum_map");
/*  307 */       _v_.unmarshal(_os_);
/*  308 */       this.tss_sum_map.put(_k_, _v_);
/*      */     }
/*      */     
/*  311 */     this.first_recharge_status = _os_.unmarshal_int();
/*  312 */     this.recharge_times = _os_.unmarshal_int();
/*  313 */     this.statis_recharge_first_consume_status = _os_.unmarshal_int();
/*      */     
/*  315 */     int size = _os_.uncompact_uint32();
/*  316 */     if (size >= 12)
/*      */     {
/*  318 */       this.save_amt_activity_infos = new HashMap(size * 2);
/*      */     }
/*  320 */     for (; size > 0; size--)
/*      */     {
/*  322 */       int _k_ = 0;
/*  323 */       _k_ = _os_.unmarshal_int();
/*  324 */       xbean.SaveAmtActivityInfo _v_ = new SaveAmtActivityInfo(0, this, "save_amt_activity_infos");
/*  325 */       _v_.unmarshal(_os_);
/*  326 */       this.save_amt_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  330 */     int size = _os_.uncompact_uint32();
/*  331 */     if (size >= 12)
/*      */     {
/*  333 */       this.level_growth_fund_activity_infos = new HashMap(size * 2);
/*      */     }
/*  335 */     for (; size > 0; size--)
/*      */     {
/*  337 */       int _k_ = 0;
/*  338 */       _k_ = _os_.unmarshal_int();
/*  339 */       xbean.LevelGrowthFundActivityInfo _v_ = new LevelGrowthFundActivityInfo(0, this, "level_growth_fund_activity_infos");
/*  340 */       _v_.unmarshal(_os_);
/*  341 */       this.level_growth_fund_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  345 */     int size = _os_.uncompact_uint32();
/*  346 */     if (size >= 12)
/*      */     {
/*  348 */       this.moth_card_activity_infos = new HashMap(size * 2);
/*      */     }
/*  350 */     for (; size > 0; size--)
/*      */     {
/*  352 */       int _k_ = 0;
/*  353 */       _k_ = _os_.unmarshal_int();
/*  354 */       xbean.MonthCardActivityInfo _v_ = new MonthCardActivityInfo(0, this, "moth_card_activity_infos");
/*  355 */       _v_.unmarshal(_os_);
/*  356 */       this.moth_card_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  360 */     int size = _os_.uncompact_uint32();
/*  361 */     if (size >= 12)
/*      */     {
/*  363 */       this.accum_total_cost_activity_infos = new HashMap(size * 2);
/*      */     }
/*  365 */     for (; size > 0; size--)
/*      */     {
/*  367 */       int _k_ = 0;
/*  368 */       _k_ = _os_.unmarshal_int();
/*  369 */       xbean.AccumTotalCostActivityInfo _v_ = new AccumTotalCostActivityInfo(0, this, "accum_total_cost_activity_infos");
/*  370 */       _v_.unmarshal(_os_);
/*  371 */       this.accum_total_cost_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  375 */     int size = _os_.uncompact_uint32();
/*  376 */     if (size >= 12)
/*      */     {
/*  378 */       this.rmb_gift_bag_activity_infos = new HashMap(size * 2);
/*      */     }
/*  380 */     for (; size > 0; size--)
/*      */     {
/*  382 */       int _k_ = 0;
/*  383 */       _k_ = _os_.unmarshal_int();
/*  384 */       xbean.RMBGiftBagActivityInfo _v_ = new RMBGiftBagActivityInfo(0, this, "rmb_gift_bag_activity_infos");
/*  385 */       _v_.unmarshal(_os_);
/*  386 */       this.rmb_gift_bag_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  389 */     this.recently_cash_infos.unmarshal(_os_);
/*  390 */     this.total_cash_amt = _os_.unmarshal_long();
/*  391 */     this.inner_save_amt = _os_.unmarshal_long();
/*  392 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  402 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.appid, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  406 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  408 */     _size_ += CodedOutputStream.computeInt64Size(2, this.save_amt);
/*  409 */     _size_ += CodedOutputStream.computeInt64Size(3, this.total_cash);
/*  410 */     _size_ += CodedOutputStream.computeInt64Size(4, this.total_cost);
/*  411 */     _size_ += CodedOutputStream.computeInt64Size(5, this.total_cost_bind);
/*  412 */     _size_ += CodedOutputStream.computeInt64Size(6, this.total_present);
/*  413 */     _size_ += CodedOutputStream.computeInt64Size(7, this.total_present_bind);
/*  414 */     _size_ += CodedOutputStream.computeInt64Size(8, this.total_confirm_cost);
/*  415 */     _size_ += CodedOutputStream.computeInt64Size(9, this.total_confirm_cost_bind);
/*  416 */     _size_ += CodedOutputStream.computeInt64Size(10, this.total_confirm_present);
/*  417 */     _size_ += CodedOutputStream.computeInt64Size(11, this.total_confirm_present_bind);
/*      */     try
/*      */     {
/*  420 */       _size_ += CodedOutputStream.computeBytesSize(12, ByteString.copyFrom(this.tss_list, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  424 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  426 */     for (Map.Entry<String, xbean.TssSumInfo> _e_ : this.tss_sum_map.entrySet())
/*      */     {
/*      */       try
/*      */       {
/*  430 */         _size_ += CodedOutputStream.computeBytesSize(13, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  434 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  436 */       _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */     }
/*  438 */     _size_ += CodedOutputStream.computeInt32Size(14, this.first_recharge_status);
/*  439 */     _size_ += CodedOutputStream.computeInt32Size(15, this.recharge_times);
/*  440 */     _size_ += CodedOutputStream.computeInt32Size(16, this.statis_recharge_first_consume_status);
/*  441 */     for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : this.save_amt_activity_infos.entrySet())
/*      */     {
/*  443 */       _size_ += CodedOutputStream.computeInt32Size(17, ((Integer)_e_.getKey()).intValue());
/*  444 */       _size_ += CodedOutputStream.computeMessageSize(17, (Message)_e_.getValue());
/*      */     }
/*  446 */     for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : this.level_growth_fund_activity_infos.entrySet())
/*      */     {
/*  448 */       _size_ += CodedOutputStream.computeInt32Size(18, ((Integer)_e_.getKey()).intValue());
/*  449 */       _size_ += CodedOutputStream.computeMessageSize(18, (Message)_e_.getValue());
/*      */     }
/*  451 */     for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : this.moth_card_activity_infos.entrySet())
/*      */     {
/*  453 */       _size_ += CodedOutputStream.computeInt32Size(19, ((Integer)_e_.getKey()).intValue());
/*  454 */       _size_ += CodedOutputStream.computeMessageSize(19, (Message)_e_.getValue());
/*      */     }
/*  456 */     for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : this.accum_total_cost_activity_infos.entrySet())
/*      */     {
/*  458 */       _size_ += CodedOutputStream.computeInt32Size(20, ((Integer)_e_.getKey()).intValue());
/*  459 */       _size_ += CodedOutputStream.computeMessageSize(20, (Message)_e_.getValue());
/*      */     }
/*  461 */     for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : this.rmb_gift_bag_activity_infos.entrySet())
/*      */     {
/*  463 */       _size_ += CodedOutputStream.computeInt32Size(21, ((Integer)_e_.getKey()).intValue());
/*  464 */       _size_ += CodedOutputStream.computeMessageSize(21, (Message)_e_.getValue());
/*      */     }
/*  466 */     _size_ += CodedOutputStream.computeMessageSize(22, this.recently_cash_infos);
/*  467 */     _size_ += CodedOutputStream.computeInt64Size(23, this.total_cash_amt);
/*  468 */     _size_ += CodedOutputStream.computeInt64Size(24, this.inner_save_amt);
/*  469 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  478 */       _output_.writeBytes(1, ByteString.copyFrom(this.appid, "UTF-16LE"));
/*  479 */       _output_.writeInt64(2, this.save_amt);
/*  480 */       _output_.writeInt64(3, this.total_cash);
/*  481 */       _output_.writeInt64(4, this.total_cost);
/*  482 */       _output_.writeInt64(5, this.total_cost_bind);
/*  483 */       _output_.writeInt64(6, this.total_present);
/*  484 */       _output_.writeInt64(7, this.total_present_bind);
/*  485 */       _output_.writeInt64(8, this.total_confirm_cost);
/*  486 */       _output_.writeInt64(9, this.total_confirm_cost_bind);
/*  487 */       _output_.writeInt64(10, this.total_confirm_present);
/*  488 */       _output_.writeInt64(11, this.total_confirm_present_bind);
/*  489 */       _output_.writeBytes(12, ByteString.copyFrom(this.tss_list, "UTF-16LE"));
/*  490 */       for (Map.Entry<String, xbean.TssSumInfo> _e_ : this.tss_sum_map.entrySet())
/*      */       {
/*  492 */         _output_.writeBytes(13, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*  493 */         _output_.writeMessage(13, (Message)_e_.getValue());
/*      */       }
/*  495 */       _output_.writeInt32(14, this.first_recharge_status);
/*  496 */       _output_.writeInt32(15, this.recharge_times);
/*  497 */       _output_.writeInt32(16, this.statis_recharge_first_consume_status);
/*  498 */       for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : this.save_amt_activity_infos.entrySet())
/*      */       {
/*  500 */         _output_.writeInt32(17, ((Integer)_e_.getKey()).intValue());
/*  501 */         _output_.writeMessage(17, (Message)_e_.getValue());
/*      */       }
/*  503 */       for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : this.level_growth_fund_activity_infos.entrySet())
/*      */       {
/*  505 */         _output_.writeInt32(18, ((Integer)_e_.getKey()).intValue());
/*  506 */         _output_.writeMessage(18, (Message)_e_.getValue());
/*      */       }
/*  508 */       for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : this.moth_card_activity_infos.entrySet())
/*      */       {
/*  510 */         _output_.writeInt32(19, ((Integer)_e_.getKey()).intValue());
/*  511 */         _output_.writeMessage(19, (Message)_e_.getValue());
/*      */       }
/*  513 */       for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : this.accum_total_cost_activity_infos.entrySet())
/*      */       {
/*  515 */         _output_.writeInt32(20, ((Integer)_e_.getKey()).intValue());
/*  516 */         _output_.writeMessage(20, (Message)_e_.getValue());
/*      */       }
/*  518 */       for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : this.rmb_gift_bag_activity_infos.entrySet())
/*      */       {
/*  520 */         _output_.writeInt32(21, ((Integer)_e_.getKey()).intValue());
/*  521 */         _output_.writeMessage(21, (Message)_e_.getValue());
/*      */       }
/*  523 */       _output_.writeMessage(22, this.recently_cash_infos);
/*  524 */       _output_.writeInt64(23, this.total_cash_amt);
/*  525 */       _output_.writeInt64(24, this.inner_save_amt);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  529 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  531 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  537 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  540 */       boolean done = false;
/*  541 */       while (!done)
/*      */       {
/*  543 */         int tag = _input_.readTag();
/*  544 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  548 */           done = true;
/*  549 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  553 */           this.appid = _input_.readBytes().toString("UTF-16LE");
/*  554 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  558 */           this.save_amt = _input_.readInt64();
/*  559 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  563 */           this.total_cash = _input_.readInt64();
/*  564 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  568 */           this.total_cost = _input_.readInt64();
/*  569 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  573 */           this.total_cost_bind = _input_.readInt64();
/*  574 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  578 */           this.total_present = _input_.readInt64();
/*  579 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  583 */           this.total_present_bind = _input_.readInt64();
/*  584 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  588 */           this.total_confirm_cost = _input_.readInt64();
/*  589 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  593 */           this.total_confirm_cost_bind = _input_.readInt64();
/*  594 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  598 */           this.total_confirm_present = _input_.readInt64();
/*  599 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  603 */           this.total_confirm_present_bind = _input_.readInt64();
/*  604 */           break;
/*      */         
/*      */ 
/*      */         case 98: 
/*  608 */           this.tss_list = _input_.readBytes().toString("UTF-16LE");
/*  609 */           break;
/*      */         
/*      */ 
/*      */         case 106: 
/*  613 */           String _k_ = "";
/*  614 */           _k_ = _input_.readBytes().toString("UTF-16LE");
/*  615 */           int readTag = _input_.readTag();
/*  616 */           if (106 != readTag)
/*      */           {
/*  618 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  620 */           xbean.TssSumInfo _v_ = new TssSumInfo(0, this, "tss_sum_map");
/*  621 */           _input_.readMessage(_v_);
/*  622 */           this.tss_sum_map.put(_k_, _v_);
/*  623 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  627 */           this.first_recharge_status = _input_.readInt32();
/*  628 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  632 */           this.recharge_times = _input_.readInt32();
/*  633 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  637 */           this.statis_recharge_first_consume_status = _input_.readInt32();
/*  638 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  642 */           int _k_ = 0;
/*  643 */           _k_ = _input_.readInt32();
/*  644 */           int readTag = _input_.readTag();
/*  645 */           if (138 != readTag)
/*      */           {
/*  647 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  649 */           xbean.SaveAmtActivityInfo _v_ = new SaveAmtActivityInfo(0, this, "save_amt_activity_infos");
/*  650 */           _input_.readMessage(_v_);
/*  651 */           this.save_amt_activity_infos.put(Integer.valueOf(_k_), _v_);
/*  652 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  656 */           int _k_ = 0;
/*  657 */           _k_ = _input_.readInt32();
/*  658 */           int readTag = _input_.readTag();
/*  659 */           if (146 != readTag)
/*      */           {
/*  661 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  663 */           xbean.LevelGrowthFundActivityInfo _v_ = new LevelGrowthFundActivityInfo(0, this, "level_growth_fund_activity_infos");
/*  664 */           _input_.readMessage(_v_);
/*  665 */           this.level_growth_fund_activity_infos.put(Integer.valueOf(_k_), _v_);
/*  666 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  670 */           int _k_ = 0;
/*  671 */           _k_ = _input_.readInt32();
/*  672 */           int readTag = _input_.readTag();
/*  673 */           if (154 != readTag)
/*      */           {
/*  675 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  677 */           xbean.MonthCardActivityInfo _v_ = new MonthCardActivityInfo(0, this, "moth_card_activity_infos");
/*  678 */           _input_.readMessage(_v_);
/*  679 */           this.moth_card_activity_infos.put(Integer.valueOf(_k_), _v_);
/*  680 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  684 */           int _k_ = 0;
/*  685 */           _k_ = _input_.readInt32();
/*  686 */           int readTag = _input_.readTag();
/*  687 */           if (162 != readTag)
/*      */           {
/*  689 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  691 */           xbean.AccumTotalCostActivityInfo _v_ = new AccumTotalCostActivityInfo(0, this, "accum_total_cost_activity_infos");
/*  692 */           _input_.readMessage(_v_);
/*  693 */           this.accum_total_cost_activity_infos.put(Integer.valueOf(_k_), _v_);
/*  694 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  698 */           int _k_ = 0;
/*  699 */           _k_ = _input_.readInt32();
/*  700 */           int readTag = _input_.readTag();
/*  701 */           if (170 != readTag)
/*      */           {
/*  703 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  705 */           xbean.RMBGiftBagActivityInfo _v_ = new RMBGiftBagActivityInfo(0, this, "rmb_gift_bag_activity_infos");
/*  706 */           _input_.readMessage(_v_);
/*  707 */           this.rmb_gift_bag_activity_infos.put(Integer.valueOf(_k_), _v_);
/*  708 */           break;
/*      */         
/*      */ 
/*      */         case 178: 
/*  712 */           _input_.readMessage(this.recently_cash_infos);
/*  713 */           break;
/*      */         
/*      */ 
/*      */         case 184: 
/*  717 */           this.total_cash_amt = _input_.readInt64();
/*  718 */           break;
/*      */         
/*      */ 
/*      */         case 192: 
/*  722 */           this.inner_save_amt = _input_.readInt64();
/*  723 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  727 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  729 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  738 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  742 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  744 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QingfuInfo copy()
/*      */   {
/*  750 */     _xdb_verify_unsafe_();
/*  751 */     return new QingfuInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QingfuInfo toData()
/*      */   {
/*  757 */     _xdb_verify_unsafe_();
/*  758 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.QingfuInfo toBean()
/*      */   {
/*  763 */     _xdb_verify_unsafe_();
/*  764 */     return new QingfuInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QingfuInfo toDataIf()
/*      */   {
/*  770 */     _xdb_verify_unsafe_();
/*  771 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.QingfuInfo toBeanIf()
/*      */   {
/*  776 */     _xdb_verify_unsafe_();
/*  777 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  783 */     _xdb_verify_unsafe_();
/*  784 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getAppid()
/*      */   {
/*  791 */     _xdb_verify_unsafe_();
/*  792 */     return this.appid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getAppidOctets()
/*      */   {
/*  799 */     _xdb_verify_unsafe_();
/*  800 */     return Octets.wrap(getAppid(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSave_amt()
/*      */   {
/*  807 */     _xdb_verify_unsafe_();
/*  808 */     return this.save_amt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_cash()
/*      */   {
/*  815 */     _xdb_verify_unsafe_();
/*  816 */     return this.total_cash;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_cost()
/*      */   {
/*  823 */     _xdb_verify_unsafe_();
/*  824 */     return this.total_cost;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_cost_bind()
/*      */   {
/*  831 */     _xdb_verify_unsafe_();
/*  832 */     return this.total_cost_bind;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_present()
/*      */   {
/*  839 */     _xdb_verify_unsafe_();
/*  840 */     return this.total_present;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_present_bind()
/*      */   {
/*  847 */     _xdb_verify_unsafe_();
/*  848 */     return this.total_present_bind;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_confirm_cost()
/*      */   {
/*  855 */     _xdb_verify_unsafe_();
/*  856 */     return this.total_confirm_cost;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_confirm_cost_bind()
/*      */   {
/*  863 */     _xdb_verify_unsafe_();
/*  864 */     return this.total_confirm_cost_bind;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_confirm_present()
/*      */   {
/*  871 */     _xdb_verify_unsafe_();
/*  872 */     return this.total_confirm_present;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_confirm_present_bind()
/*      */   {
/*  879 */     _xdb_verify_unsafe_();
/*  880 */     return this.total_confirm_present_bind;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getTss_list()
/*      */   {
/*  887 */     _xdb_verify_unsafe_();
/*  888 */     return this.tss_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getTss_listOctets()
/*      */   {
/*  895 */     _xdb_verify_unsafe_();
/*  896 */     return Octets.wrap(getTss_list(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<String, xbean.TssSumInfo> getTss_sum_map()
/*      */   {
/*  903 */     _xdb_verify_unsafe_();
/*  904 */     return Logs.logMap(new LogKey(this, "tss_sum_map"), this.tss_sum_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<String, xbean.TssSumInfo> getTss_sum_mapAsData()
/*      */   {
/*  911 */     _xdb_verify_unsafe_();
/*      */     
/*  913 */     QingfuInfo _o_ = this;
/*  914 */     Map<String, xbean.TssSumInfo> tss_sum_map = new HashMap();
/*  915 */     for (Map.Entry<String, xbean.TssSumInfo> _e_ : _o_.tss_sum_map.entrySet())
/*  916 */       tss_sum_map.put(_e_.getKey(), new TssSumInfo.Data((xbean.TssSumInfo)_e_.getValue()));
/*  917 */     return tss_sum_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFirst_recharge_status()
/*      */   {
/*  924 */     _xdb_verify_unsafe_();
/*  925 */     return this.first_recharge_status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRecharge_times()
/*      */   {
/*  932 */     _xdb_verify_unsafe_();
/*  933 */     return this.recharge_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStatis_recharge_first_consume_status()
/*      */   {
/*  940 */     _xdb_verify_unsafe_();
/*  941 */     return this.statis_recharge_first_consume_status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SaveAmtActivityInfo> getSave_amt_activity_infos()
/*      */   {
/*  948 */     _xdb_verify_unsafe_();
/*  949 */     return Logs.logMap(new LogKey(this, "save_amt_activity_infos"), this.save_amt_activity_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SaveAmtActivityInfo> getSave_amt_activity_infosAsData()
/*      */   {
/*  956 */     _xdb_verify_unsafe_();
/*      */     
/*  958 */     QingfuInfo _o_ = this;
/*  959 */     Map<Integer, xbean.SaveAmtActivityInfo> save_amt_activity_infos = new HashMap();
/*  960 */     for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : _o_.save_amt_activity_infos.entrySet())
/*  961 */       save_amt_activity_infos.put(_e_.getKey(), new SaveAmtActivityInfo.Data((xbean.SaveAmtActivityInfo)_e_.getValue()));
/*  962 */     return save_amt_activity_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infos()
/*      */   {
/*  969 */     _xdb_verify_unsafe_();
/*  970 */     return Logs.logMap(new LogKey(this, "level_growth_fund_activity_infos"), this.level_growth_fund_activity_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infosAsData()
/*      */   {
/*  977 */     _xdb_verify_unsafe_();
/*      */     
/*  979 */     QingfuInfo _o_ = this;
/*  980 */     Map<Integer, xbean.LevelGrowthFundActivityInfo> level_growth_fund_activity_infos = new HashMap();
/*  981 */     for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : _o_.level_growth_fund_activity_infos.entrySet())
/*  982 */       level_growth_fund_activity_infos.put(_e_.getKey(), new LevelGrowthFundActivityInfo.Data((xbean.LevelGrowthFundActivityInfo)_e_.getValue()));
/*  983 */     return level_growth_fund_activity_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MonthCardActivityInfo> getMoth_card_activity_infos()
/*      */   {
/*  990 */     _xdb_verify_unsafe_();
/*  991 */     return Logs.logMap(new LogKey(this, "moth_card_activity_infos"), this.moth_card_activity_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.MonthCardActivityInfo> getMoth_card_activity_infosAsData()
/*      */   {
/*  998 */     _xdb_verify_unsafe_();
/*      */     
/* 1000 */     QingfuInfo _o_ = this;
/* 1001 */     Map<Integer, xbean.MonthCardActivityInfo> moth_card_activity_infos = new HashMap();
/* 1002 */     for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : _o_.moth_card_activity_infos.entrySet())
/* 1003 */       moth_card_activity_infos.put(_e_.getKey(), new MonthCardActivityInfo.Data((xbean.MonthCardActivityInfo)_e_.getValue()));
/* 1004 */     return moth_card_activity_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.AccumTotalCostActivityInfo> getAccum_total_cost_activity_infos()
/*      */   {
/* 1011 */     _xdb_verify_unsafe_();
/* 1012 */     return Logs.logMap(new LogKey(this, "accum_total_cost_activity_infos"), this.accum_total_cost_activity_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.AccumTotalCostActivityInfo> getAccum_total_cost_activity_infosAsData()
/*      */   {
/* 1019 */     _xdb_verify_unsafe_();
/*      */     
/* 1021 */     QingfuInfo _o_ = this;
/* 1022 */     Map<Integer, xbean.AccumTotalCostActivityInfo> accum_total_cost_activity_infos = new HashMap();
/* 1023 */     for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : _o_.accum_total_cost_activity_infos.entrySet())
/* 1024 */       accum_total_cost_activity_infos.put(_e_.getKey(), new AccumTotalCostActivityInfo.Data((xbean.AccumTotalCostActivityInfo)_e_.getValue()));
/* 1025 */     return accum_total_cost_activity_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infos()
/*      */   {
/* 1032 */     _xdb_verify_unsafe_();
/* 1033 */     return Logs.logMap(new LogKey(this, "rmb_gift_bag_activity_infos"), this.rmb_gift_bag_activity_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infosAsData()
/*      */   {
/* 1040 */     _xdb_verify_unsafe_();
/*      */     
/* 1042 */     QingfuInfo _o_ = this;
/* 1043 */     Map<Integer, xbean.RMBGiftBagActivityInfo> rmb_gift_bag_activity_infos = new HashMap();
/* 1044 */     for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : _o_.rmb_gift_bag_activity_infos.entrySet())
/* 1045 */       rmb_gift_bag_activity_infos.put(_e_.getKey(), new RMBGiftBagActivityInfo.Data((xbean.RMBGiftBagActivityInfo)_e_.getValue()));
/* 1046 */     return rmb_gift_bag_activity_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.RecentlyCashInfo getRecently_cash_infos()
/*      */   {
/* 1053 */     _xdb_verify_unsafe_();
/* 1054 */     return this.recently_cash_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotal_cash_amt()
/*      */   {
/* 1061 */     _xdb_verify_unsafe_();
/* 1062 */     return this.total_cash_amt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInner_save_amt()
/*      */   {
/* 1069 */     _xdb_verify_unsafe_();
/* 1070 */     return this.inner_save_amt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAppid(String _v_)
/*      */   {
/* 1077 */     _xdb_verify_unsafe_();
/* 1078 */     if (null == _v_)
/* 1079 */       throw new NullPointerException();
/* 1080 */     Logs.logIf(new LogKey(this, "appid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1084 */         new LogString(this, QingfuInfo.this.appid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1088 */             QingfuInfo.this.appid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1092 */     });
/* 1093 */     this.appid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAppidOctets(Octets _v_)
/*      */   {
/* 1100 */     _xdb_verify_unsafe_();
/* 1101 */     setAppid(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSave_amt(long _v_)
/*      */   {
/* 1108 */     _xdb_verify_unsafe_();
/* 1109 */     Logs.logIf(new LogKey(this, "save_amt")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1113 */         new LogLong(this, QingfuInfo.this.save_amt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1117 */             QingfuInfo.this.save_amt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1121 */     });
/* 1122 */     this.save_amt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_cash(long _v_)
/*      */   {
/* 1129 */     _xdb_verify_unsafe_();
/* 1130 */     Logs.logIf(new LogKey(this, "total_cash")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1134 */         new LogLong(this, QingfuInfo.this.total_cash)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1138 */             QingfuInfo.this.total_cash = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1142 */     });
/* 1143 */     this.total_cash = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_cost(long _v_)
/*      */   {
/* 1150 */     _xdb_verify_unsafe_();
/* 1151 */     Logs.logIf(new LogKey(this, "total_cost")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1155 */         new LogLong(this, QingfuInfo.this.total_cost)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1159 */             QingfuInfo.this.total_cost = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1163 */     });
/* 1164 */     this.total_cost = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_cost_bind(long _v_)
/*      */   {
/* 1171 */     _xdb_verify_unsafe_();
/* 1172 */     Logs.logIf(new LogKey(this, "total_cost_bind")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1176 */         new LogLong(this, QingfuInfo.this.total_cost_bind)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1180 */             QingfuInfo.this.total_cost_bind = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1184 */     });
/* 1185 */     this.total_cost_bind = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_present(long _v_)
/*      */   {
/* 1192 */     _xdb_verify_unsafe_();
/* 1193 */     Logs.logIf(new LogKey(this, "total_present")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1197 */         new LogLong(this, QingfuInfo.this.total_present)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1201 */             QingfuInfo.this.total_present = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1205 */     });
/* 1206 */     this.total_present = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_present_bind(long _v_)
/*      */   {
/* 1213 */     _xdb_verify_unsafe_();
/* 1214 */     Logs.logIf(new LogKey(this, "total_present_bind")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1218 */         new LogLong(this, QingfuInfo.this.total_present_bind)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1222 */             QingfuInfo.this.total_present_bind = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1226 */     });
/* 1227 */     this.total_present_bind = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_confirm_cost(long _v_)
/*      */   {
/* 1234 */     _xdb_verify_unsafe_();
/* 1235 */     Logs.logIf(new LogKey(this, "total_confirm_cost")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1239 */         new LogLong(this, QingfuInfo.this.total_confirm_cost)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1243 */             QingfuInfo.this.total_confirm_cost = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1247 */     });
/* 1248 */     this.total_confirm_cost = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_confirm_cost_bind(long _v_)
/*      */   {
/* 1255 */     _xdb_verify_unsafe_();
/* 1256 */     Logs.logIf(new LogKey(this, "total_confirm_cost_bind")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1260 */         new LogLong(this, QingfuInfo.this.total_confirm_cost_bind)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1264 */             QingfuInfo.this.total_confirm_cost_bind = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1268 */     });
/* 1269 */     this.total_confirm_cost_bind = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_confirm_present(long _v_)
/*      */   {
/* 1276 */     _xdb_verify_unsafe_();
/* 1277 */     Logs.logIf(new LogKey(this, "total_confirm_present")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1281 */         new LogLong(this, QingfuInfo.this.total_confirm_present)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1285 */             QingfuInfo.this.total_confirm_present = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1289 */     });
/* 1290 */     this.total_confirm_present = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_confirm_present_bind(long _v_)
/*      */   {
/* 1297 */     _xdb_verify_unsafe_();
/* 1298 */     Logs.logIf(new LogKey(this, "total_confirm_present_bind")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1302 */         new LogLong(this, QingfuInfo.this.total_confirm_present_bind)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1306 */             QingfuInfo.this.total_confirm_present_bind = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1310 */     });
/* 1311 */     this.total_confirm_present_bind = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTss_list(String _v_)
/*      */   {
/* 1318 */     _xdb_verify_unsafe_();
/* 1319 */     if (null == _v_)
/* 1320 */       throw new NullPointerException();
/* 1321 */     Logs.logIf(new LogKey(this, "tss_list")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1325 */         new LogString(this, QingfuInfo.this.tss_list)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1329 */             QingfuInfo.this.tss_list = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1333 */     });
/* 1334 */     this.tss_list = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTss_listOctets(Octets _v_)
/*      */   {
/* 1341 */     _xdb_verify_unsafe_();
/* 1342 */     setTss_list(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFirst_recharge_status(int _v_)
/*      */   {
/* 1349 */     _xdb_verify_unsafe_();
/* 1350 */     Logs.logIf(new LogKey(this, "first_recharge_status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1354 */         new LogInt(this, QingfuInfo.this.first_recharge_status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1358 */             QingfuInfo.this.first_recharge_status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1362 */     });
/* 1363 */     this.first_recharge_status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecharge_times(int _v_)
/*      */   {
/* 1370 */     _xdb_verify_unsafe_();
/* 1371 */     Logs.logIf(new LogKey(this, "recharge_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1375 */         new LogInt(this, QingfuInfo.this.recharge_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1379 */             QingfuInfo.this.recharge_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1383 */     });
/* 1384 */     this.recharge_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatis_recharge_first_consume_status(int _v_)
/*      */   {
/* 1391 */     _xdb_verify_unsafe_();
/* 1392 */     Logs.logIf(new LogKey(this, "statis_recharge_first_consume_status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1396 */         new LogInt(this, QingfuInfo.this.statis_recharge_first_consume_status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1400 */             QingfuInfo.this.statis_recharge_first_consume_status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1404 */     });
/* 1405 */     this.statis_recharge_first_consume_status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_cash_amt(long _v_)
/*      */   {
/* 1412 */     _xdb_verify_unsafe_();
/* 1413 */     Logs.logIf(new LogKey(this, "total_cash_amt")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1417 */         new LogLong(this, QingfuInfo.this.total_cash_amt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1421 */             QingfuInfo.this.total_cash_amt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1425 */     });
/* 1426 */     this.total_cash_amt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInner_save_amt(long _v_)
/*      */   {
/* 1433 */     _xdb_verify_unsafe_();
/* 1434 */     Logs.logIf(new LogKey(this, "inner_save_amt")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1438 */         new LogLong(this, QingfuInfo.this.inner_save_amt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1442 */             QingfuInfo.this.inner_save_amt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1446 */     });
/* 1447 */     this.inner_save_amt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1453 */     _xdb_verify_unsafe_();
/* 1454 */     QingfuInfo _o_ = null;
/* 1455 */     if ((_o1_ instanceof QingfuInfo)) { _o_ = (QingfuInfo)_o1_;
/* 1456 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1457 */       return false;
/* 1458 */     if (!this.appid.equals(_o_.appid)) return false;
/* 1459 */     if (this.save_amt != _o_.save_amt) return false;
/* 1460 */     if (this.total_cash != _o_.total_cash) return false;
/* 1461 */     if (this.total_cost != _o_.total_cost) return false;
/* 1462 */     if (this.total_cost_bind != _o_.total_cost_bind) return false;
/* 1463 */     if (this.total_present != _o_.total_present) return false;
/* 1464 */     if (this.total_present_bind != _o_.total_present_bind) return false;
/* 1465 */     if (this.total_confirm_cost != _o_.total_confirm_cost) return false;
/* 1466 */     if (this.total_confirm_cost_bind != _o_.total_confirm_cost_bind) return false;
/* 1467 */     if (this.total_confirm_present != _o_.total_confirm_present) return false;
/* 1468 */     if (this.total_confirm_present_bind != _o_.total_confirm_present_bind) return false;
/* 1469 */     if (!this.tss_list.equals(_o_.tss_list)) return false;
/* 1470 */     if (!this.tss_sum_map.equals(_o_.tss_sum_map)) return false;
/* 1471 */     if (this.first_recharge_status != _o_.first_recharge_status) return false;
/* 1472 */     if (this.recharge_times != _o_.recharge_times) return false;
/* 1473 */     if (this.statis_recharge_first_consume_status != _o_.statis_recharge_first_consume_status) return false;
/* 1474 */     if (!this.save_amt_activity_infos.equals(_o_.save_amt_activity_infos)) return false;
/* 1475 */     if (!this.level_growth_fund_activity_infos.equals(_o_.level_growth_fund_activity_infos)) return false;
/* 1476 */     if (!this.moth_card_activity_infos.equals(_o_.moth_card_activity_infos)) return false;
/* 1477 */     if (!this.accum_total_cost_activity_infos.equals(_o_.accum_total_cost_activity_infos)) return false;
/* 1478 */     if (!this.rmb_gift_bag_activity_infos.equals(_o_.rmb_gift_bag_activity_infos)) return false;
/* 1479 */     if (!this.recently_cash_infos.equals(_o_.recently_cash_infos)) return false;
/* 1480 */     if (this.total_cash_amt != _o_.total_cash_amt) return false;
/* 1481 */     if (this.inner_save_amt != _o_.inner_save_amt) return false;
/* 1482 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1488 */     _xdb_verify_unsafe_();
/* 1489 */     int _h_ = 0;
/* 1490 */     _h_ += this.appid.hashCode();
/* 1491 */     _h_ = (int)(_h_ + this.save_amt);
/* 1492 */     _h_ = (int)(_h_ + this.total_cash);
/* 1493 */     _h_ = (int)(_h_ + this.total_cost);
/* 1494 */     _h_ = (int)(_h_ + this.total_cost_bind);
/* 1495 */     _h_ = (int)(_h_ + this.total_present);
/* 1496 */     _h_ = (int)(_h_ + this.total_present_bind);
/* 1497 */     _h_ = (int)(_h_ + this.total_confirm_cost);
/* 1498 */     _h_ = (int)(_h_ + this.total_confirm_cost_bind);
/* 1499 */     _h_ = (int)(_h_ + this.total_confirm_present);
/* 1500 */     _h_ = (int)(_h_ + this.total_confirm_present_bind);
/* 1501 */     _h_ += this.tss_list.hashCode();
/* 1502 */     _h_ += this.tss_sum_map.hashCode();
/* 1503 */     _h_ += this.first_recharge_status;
/* 1504 */     _h_ += this.recharge_times;
/* 1505 */     _h_ += this.statis_recharge_first_consume_status;
/* 1506 */     _h_ += this.save_amt_activity_infos.hashCode();
/* 1507 */     _h_ += this.level_growth_fund_activity_infos.hashCode();
/* 1508 */     _h_ += this.moth_card_activity_infos.hashCode();
/* 1509 */     _h_ += this.accum_total_cost_activity_infos.hashCode();
/* 1510 */     _h_ += this.rmb_gift_bag_activity_infos.hashCode();
/* 1511 */     _h_ += this.recently_cash_infos.hashCode();
/* 1512 */     _h_ = (int)(_h_ + this.total_cash_amt);
/* 1513 */     _h_ = (int)(_h_ + this.inner_save_amt);
/* 1514 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1520 */     _xdb_verify_unsafe_();
/* 1521 */     StringBuilder _sb_ = new StringBuilder();
/* 1522 */     _sb_.append("(");
/* 1523 */     _sb_.append("'").append(this.appid).append("'");
/* 1524 */     _sb_.append(",");
/* 1525 */     _sb_.append(this.save_amt);
/* 1526 */     _sb_.append(",");
/* 1527 */     _sb_.append(this.total_cash);
/* 1528 */     _sb_.append(",");
/* 1529 */     _sb_.append(this.total_cost);
/* 1530 */     _sb_.append(",");
/* 1531 */     _sb_.append(this.total_cost_bind);
/* 1532 */     _sb_.append(",");
/* 1533 */     _sb_.append(this.total_present);
/* 1534 */     _sb_.append(",");
/* 1535 */     _sb_.append(this.total_present_bind);
/* 1536 */     _sb_.append(",");
/* 1537 */     _sb_.append(this.total_confirm_cost);
/* 1538 */     _sb_.append(",");
/* 1539 */     _sb_.append(this.total_confirm_cost_bind);
/* 1540 */     _sb_.append(",");
/* 1541 */     _sb_.append(this.total_confirm_present);
/* 1542 */     _sb_.append(",");
/* 1543 */     _sb_.append(this.total_confirm_present_bind);
/* 1544 */     _sb_.append(",");
/* 1545 */     _sb_.append("'").append(this.tss_list).append("'");
/* 1546 */     _sb_.append(",");
/* 1547 */     _sb_.append(this.tss_sum_map);
/* 1548 */     _sb_.append(",");
/* 1549 */     _sb_.append(this.first_recharge_status);
/* 1550 */     _sb_.append(",");
/* 1551 */     _sb_.append(this.recharge_times);
/* 1552 */     _sb_.append(",");
/* 1553 */     _sb_.append(this.statis_recharge_first_consume_status);
/* 1554 */     _sb_.append(",");
/* 1555 */     _sb_.append(this.save_amt_activity_infos);
/* 1556 */     _sb_.append(",");
/* 1557 */     _sb_.append(this.level_growth_fund_activity_infos);
/* 1558 */     _sb_.append(",");
/* 1559 */     _sb_.append(this.moth_card_activity_infos);
/* 1560 */     _sb_.append(",");
/* 1561 */     _sb_.append(this.accum_total_cost_activity_infos);
/* 1562 */     _sb_.append(",");
/* 1563 */     _sb_.append(this.rmb_gift_bag_activity_infos);
/* 1564 */     _sb_.append(",");
/* 1565 */     _sb_.append(this.recently_cash_infos);
/* 1566 */     _sb_.append(",");
/* 1567 */     _sb_.append(this.total_cash_amt);
/* 1568 */     _sb_.append(",");
/* 1569 */     _sb_.append(this.inner_save_amt);
/* 1570 */     _sb_.append(")");
/* 1571 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1577 */     ListenableBean lb = new ListenableBean();
/* 1578 */     lb.add(new ListenableChanged().setVarName("appid"));
/* 1579 */     lb.add(new ListenableChanged().setVarName("save_amt"));
/* 1580 */     lb.add(new ListenableChanged().setVarName("total_cash"));
/* 1581 */     lb.add(new ListenableChanged().setVarName("total_cost"));
/* 1582 */     lb.add(new ListenableChanged().setVarName("total_cost_bind"));
/* 1583 */     lb.add(new ListenableChanged().setVarName("total_present"));
/* 1584 */     lb.add(new ListenableChanged().setVarName("total_present_bind"));
/* 1585 */     lb.add(new ListenableChanged().setVarName("total_confirm_cost"));
/* 1586 */     lb.add(new ListenableChanged().setVarName("total_confirm_cost_bind"));
/* 1587 */     lb.add(new ListenableChanged().setVarName("total_confirm_present"));
/* 1588 */     lb.add(new ListenableChanged().setVarName("total_confirm_present_bind"));
/* 1589 */     lb.add(new ListenableChanged().setVarName("tss_list"));
/* 1590 */     lb.add(new ListenableMap().setVarName("tss_sum_map"));
/* 1591 */     lb.add(new ListenableChanged().setVarName("first_recharge_status"));
/* 1592 */     lb.add(new ListenableChanged().setVarName("recharge_times"));
/* 1593 */     lb.add(new ListenableChanged().setVarName("statis_recharge_first_consume_status"));
/* 1594 */     lb.add(new ListenableMap().setVarName("save_amt_activity_infos"));
/* 1595 */     lb.add(new ListenableMap().setVarName("level_growth_fund_activity_infos"));
/* 1596 */     lb.add(new ListenableMap().setVarName("moth_card_activity_infos"));
/* 1597 */     lb.add(new ListenableMap().setVarName("accum_total_cost_activity_infos"));
/* 1598 */     lb.add(new ListenableMap().setVarName("rmb_gift_bag_activity_infos"));
/* 1599 */     lb.add(new ListenableChanged().setVarName("recently_cash_infos"));
/* 1600 */     lb.add(new ListenableChanged().setVarName("total_cash_amt"));
/* 1601 */     lb.add(new ListenableChanged().setVarName("inner_save_amt"));
/* 1602 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.QingfuInfo {
/*      */     private Const() {}
/*      */     
/*      */     QingfuInfo nThis() {
/* 1609 */       return QingfuInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1615 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QingfuInfo copy()
/*      */     {
/* 1621 */       return QingfuInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QingfuInfo toData()
/*      */     {
/* 1627 */       return QingfuInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.QingfuInfo toBean()
/*      */     {
/* 1632 */       return QingfuInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QingfuInfo toDataIf()
/*      */     {
/* 1638 */       return QingfuInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.QingfuInfo toBeanIf()
/*      */     {
/* 1643 */       return QingfuInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAppid()
/*      */     {
/* 1650 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1651 */       return QingfuInfo.this.appid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAppidOctets()
/*      */     {
/* 1658 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1659 */       return QingfuInfo.this.getAppidOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSave_amt()
/*      */     {
/* 1666 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1667 */       return QingfuInfo.this.save_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cash()
/*      */     {
/* 1674 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1675 */       return QingfuInfo.this.total_cash;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cost()
/*      */     {
/* 1682 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1683 */       return QingfuInfo.this.total_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cost_bind()
/*      */     {
/* 1690 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1691 */       return QingfuInfo.this.total_cost_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_present()
/*      */     {
/* 1698 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1699 */       return QingfuInfo.this.total_present;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_present_bind()
/*      */     {
/* 1706 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1707 */       return QingfuInfo.this.total_present_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_cost()
/*      */     {
/* 1714 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1715 */       return QingfuInfo.this.total_confirm_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_cost_bind()
/*      */     {
/* 1722 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1723 */       return QingfuInfo.this.total_confirm_cost_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_present()
/*      */     {
/* 1730 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1731 */       return QingfuInfo.this.total_confirm_present;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_present_bind()
/*      */     {
/* 1738 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1739 */       return QingfuInfo.this.total_confirm_present_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getTss_list()
/*      */     {
/* 1746 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1747 */       return QingfuInfo.this.tss_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getTss_listOctets()
/*      */     {
/* 1754 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1755 */       return QingfuInfo.this.getTss_listOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, xbean.TssSumInfo> getTss_sum_map()
/*      */     {
/* 1762 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1763 */       return Consts.constMap(QingfuInfo.this.tss_sum_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, xbean.TssSumInfo> getTss_sum_mapAsData()
/*      */     {
/* 1770 */       QingfuInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1772 */       QingfuInfo _o_ = QingfuInfo.this;
/* 1773 */       Map<String, xbean.TssSumInfo> tss_sum_map = new HashMap();
/* 1774 */       for (Map.Entry<String, xbean.TssSumInfo> _e_ : _o_.tss_sum_map.entrySet())
/* 1775 */         tss_sum_map.put(_e_.getKey(), new TssSumInfo.Data((xbean.TssSumInfo)_e_.getValue()));
/* 1776 */       return tss_sum_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFirst_recharge_status()
/*      */     {
/* 1783 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1784 */       return QingfuInfo.this.first_recharge_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecharge_times()
/*      */     {
/* 1791 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1792 */       return QingfuInfo.this.recharge_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatis_recharge_first_consume_status()
/*      */     {
/* 1799 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1800 */       return QingfuInfo.this.statis_recharge_first_consume_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SaveAmtActivityInfo> getSave_amt_activity_infos()
/*      */     {
/* 1807 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1808 */       return Consts.constMap(QingfuInfo.this.save_amt_activity_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SaveAmtActivityInfo> getSave_amt_activity_infosAsData()
/*      */     {
/* 1815 */       QingfuInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1817 */       QingfuInfo _o_ = QingfuInfo.this;
/* 1818 */       Map<Integer, xbean.SaveAmtActivityInfo> save_amt_activity_infos = new HashMap();
/* 1819 */       for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : _o_.save_amt_activity_infos.entrySet())
/* 1820 */         save_amt_activity_infos.put(_e_.getKey(), new SaveAmtActivityInfo.Data((xbean.SaveAmtActivityInfo)_e_.getValue()));
/* 1821 */       return save_amt_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infos()
/*      */     {
/* 1828 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1829 */       return Consts.constMap(QingfuInfo.this.level_growth_fund_activity_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infosAsData()
/*      */     {
/* 1836 */       QingfuInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1838 */       QingfuInfo _o_ = QingfuInfo.this;
/* 1839 */       Map<Integer, xbean.LevelGrowthFundActivityInfo> level_growth_fund_activity_infos = new HashMap();
/* 1840 */       for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : _o_.level_growth_fund_activity_infos.entrySet())
/* 1841 */         level_growth_fund_activity_infos.put(_e_.getKey(), new LevelGrowthFundActivityInfo.Data((xbean.LevelGrowthFundActivityInfo)_e_.getValue()));
/* 1842 */       return level_growth_fund_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MonthCardActivityInfo> getMoth_card_activity_infos()
/*      */     {
/* 1849 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1850 */       return Consts.constMap(QingfuInfo.this.moth_card_activity_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MonthCardActivityInfo> getMoth_card_activity_infosAsData()
/*      */     {
/* 1857 */       QingfuInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1859 */       QingfuInfo _o_ = QingfuInfo.this;
/* 1860 */       Map<Integer, xbean.MonthCardActivityInfo> moth_card_activity_infos = new HashMap();
/* 1861 */       for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : _o_.moth_card_activity_infos.entrySet())
/* 1862 */         moth_card_activity_infos.put(_e_.getKey(), new MonthCardActivityInfo.Data((xbean.MonthCardActivityInfo)_e_.getValue()));
/* 1863 */       return moth_card_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AccumTotalCostActivityInfo> getAccum_total_cost_activity_infos()
/*      */     {
/* 1870 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1871 */       return Consts.constMap(QingfuInfo.this.accum_total_cost_activity_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AccumTotalCostActivityInfo> getAccum_total_cost_activity_infosAsData()
/*      */     {
/* 1878 */       QingfuInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1880 */       QingfuInfo _o_ = QingfuInfo.this;
/* 1881 */       Map<Integer, xbean.AccumTotalCostActivityInfo> accum_total_cost_activity_infos = new HashMap();
/* 1882 */       for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : _o_.accum_total_cost_activity_infos.entrySet())
/* 1883 */         accum_total_cost_activity_infos.put(_e_.getKey(), new AccumTotalCostActivityInfo.Data((xbean.AccumTotalCostActivityInfo)_e_.getValue()));
/* 1884 */       return accum_total_cost_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infos()
/*      */     {
/* 1891 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1892 */       return Consts.constMap(QingfuInfo.this.rmb_gift_bag_activity_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infosAsData()
/*      */     {
/* 1899 */       QingfuInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1901 */       QingfuInfo _o_ = QingfuInfo.this;
/* 1902 */       Map<Integer, xbean.RMBGiftBagActivityInfo> rmb_gift_bag_activity_infos = new HashMap();
/* 1903 */       for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : _o_.rmb_gift_bag_activity_infos.entrySet())
/* 1904 */         rmb_gift_bag_activity_infos.put(_e_.getKey(), new RMBGiftBagActivityInfo.Data((xbean.RMBGiftBagActivityInfo)_e_.getValue()));
/* 1905 */       return rmb_gift_bag_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RecentlyCashInfo getRecently_cash_infos()
/*      */     {
/* 1912 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1913 */       return (xbean.RecentlyCashInfo)Consts.toConst(QingfuInfo.this.recently_cash_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cash_amt()
/*      */     {
/* 1920 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1921 */       return QingfuInfo.this.total_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInner_save_amt()
/*      */     {
/* 1928 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1929 */       return QingfuInfo.this.inner_save_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAppid(String _v_)
/*      */     {
/* 1936 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAppidOctets(Octets _v_)
/*      */     {
/* 1944 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSave_amt(long _v_)
/*      */     {
/* 1952 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1953 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cash(long _v_)
/*      */     {
/* 1960 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1961 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cost(long _v_)
/*      */     {
/* 1968 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1969 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cost_bind(long _v_)
/*      */     {
/* 1976 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1977 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_present(long _v_)
/*      */     {
/* 1984 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1985 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_present_bind(long _v_)
/*      */     {
/* 1992 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 1993 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_cost(long _v_)
/*      */     {
/* 2000 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2001 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_cost_bind(long _v_)
/*      */     {
/* 2008 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2009 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_present(long _v_)
/*      */     {
/* 2016 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2017 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_present_bind(long _v_)
/*      */     {
/* 2024 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2025 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTss_list(String _v_)
/*      */     {
/* 2032 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2033 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTss_listOctets(Octets _v_)
/*      */     {
/* 2040 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2041 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirst_recharge_status(int _v_)
/*      */     {
/* 2048 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2049 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecharge_times(int _v_)
/*      */     {
/* 2056 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2057 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatis_recharge_first_consume_status(int _v_)
/*      */     {
/* 2064 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2065 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cash_amt(long _v_)
/*      */     {
/* 2072 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2073 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInner_save_amt(long _v_)
/*      */     {
/* 2080 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2081 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2087 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2088 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2094 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2095 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2101 */       return QingfuInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2107 */       return QingfuInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2113 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2114 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2120 */       return QingfuInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2126 */       return QingfuInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2132 */       QingfuInfo.this._xdb_verify_unsafe_();
/* 2133 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2139 */       return QingfuInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2145 */       return QingfuInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2151 */       return QingfuInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2157 */       return QingfuInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2163 */       return QingfuInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2169 */       return QingfuInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2175 */       return QingfuInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.QingfuInfo
/*      */   {
/*      */     private String appid;
/*      */     
/*      */     private long save_amt;
/*      */     
/*      */     private long total_cash;
/*      */     
/*      */     private long total_cost;
/*      */     
/*      */     private long total_cost_bind;
/*      */     
/*      */     private long total_present;
/*      */     
/*      */     private long total_present_bind;
/*      */     
/*      */     private long total_confirm_cost;
/*      */     
/*      */     private long total_confirm_cost_bind;
/*      */     
/*      */     private long total_confirm_present;
/*      */     
/*      */     private long total_confirm_present_bind;
/*      */     
/*      */     private String tss_list;
/*      */     
/*      */     private HashMap<String, xbean.TssSumInfo> tss_sum_map;
/*      */     
/*      */     private int first_recharge_status;
/*      */     
/*      */     private int recharge_times;
/*      */     
/*      */     private int statis_recharge_first_consume_status;
/*      */     
/*      */     private HashMap<Integer, xbean.SaveAmtActivityInfo> save_amt_activity_infos;
/*      */     
/*      */     private HashMap<Integer, xbean.LevelGrowthFundActivityInfo> level_growth_fund_activity_infos;
/*      */     
/*      */     private HashMap<Integer, xbean.MonthCardActivityInfo> moth_card_activity_infos;
/*      */     
/*      */     private HashMap<Integer, xbean.AccumTotalCostActivityInfo> accum_total_cost_activity_infos;
/*      */     
/*      */     private HashMap<Integer, xbean.RMBGiftBagActivityInfo> rmb_gift_bag_activity_infos;
/*      */     
/*      */     private xbean.RecentlyCashInfo recently_cash_infos;
/*      */     
/*      */     private long total_cash_amt;
/*      */     
/*      */     private long inner_save_amt;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2233 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2238 */       this.appid = "";
/* 2239 */       this.save_amt = 0L;
/* 2240 */       this.total_cash = 0L;
/* 2241 */       this.total_cost = 0L;
/* 2242 */       this.total_cost_bind = 0L;
/* 2243 */       this.total_present = 0L;
/* 2244 */       this.total_present_bind = 0L;
/* 2245 */       this.total_confirm_cost = 0L;
/* 2246 */       this.total_confirm_cost_bind = 0L;
/* 2247 */       this.total_confirm_present = 0L;
/* 2248 */       this.total_confirm_present_bind = 0L;
/* 2249 */       this.tss_list = "";
/* 2250 */       this.tss_sum_map = new HashMap();
/* 2251 */       this.first_recharge_status = 1;
/* 2252 */       this.recharge_times = 0;
/* 2253 */       this.statis_recharge_first_consume_status = 0;
/* 2254 */       this.save_amt_activity_infos = new HashMap();
/* 2255 */       this.level_growth_fund_activity_infos = new HashMap();
/* 2256 */       this.moth_card_activity_infos = new HashMap();
/* 2257 */       this.accum_total_cost_activity_infos = new HashMap();
/* 2258 */       this.rmb_gift_bag_activity_infos = new HashMap();
/* 2259 */       this.recently_cash_infos = new RecentlyCashInfo.Data();
/* 2260 */       this.total_cash_amt = 0L;
/* 2261 */       this.inner_save_amt = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.QingfuInfo _o1_)
/*      */     {
/* 2266 */       if ((_o1_ instanceof QingfuInfo)) { assign((QingfuInfo)_o1_);
/* 2267 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2268 */       } else if ((_o1_ instanceof QingfuInfo.Const)) assign(((QingfuInfo.Const)_o1_).nThis()); else {
/* 2269 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(QingfuInfo _o_) {
/* 2274 */       this.appid = _o_.appid;
/* 2275 */       this.save_amt = _o_.save_amt;
/* 2276 */       this.total_cash = _o_.total_cash;
/* 2277 */       this.total_cost = _o_.total_cost;
/* 2278 */       this.total_cost_bind = _o_.total_cost_bind;
/* 2279 */       this.total_present = _o_.total_present;
/* 2280 */       this.total_present_bind = _o_.total_present_bind;
/* 2281 */       this.total_confirm_cost = _o_.total_confirm_cost;
/* 2282 */       this.total_confirm_cost_bind = _o_.total_confirm_cost_bind;
/* 2283 */       this.total_confirm_present = _o_.total_confirm_present;
/* 2284 */       this.total_confirm_present_bind = _o_.total_confirm_present_bind;
/* 2285 */       this.tss_list = _o_.tss_list;
/* 2286 */       this.tss_sum_map = new HashMap();
/* 2287 */       for (Map.Entry<String, xbean.TssSumInfo> _e_ : _o_.tss_sum_map.entrySet())
/* 2288 */         this.tss_sum_map.put(_e_.getKey(), new TssSumInfo.Data((xbean.TssSumInfo)_e_.getValue()));
/* 2289 */       this.first_recharge_status = _o_.first_recharge_status;
/* 2290 */       this.recharge_times = _o_.recharge_times;
/* 2291 */       this.statis_recharge_first_consume_status = _o_.statis_recharge_first_consume_status;
/* 2292 */       this.save_amt_activity_infos = new HashMap();
/* 2293 */       for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : _o_.save_amt_activity_infos.entrySet())
/* 2294 */         this.save_amt_activity_infos.put(_e_.getKey(), new SaveAmtActivityInfo.Data((xbean.SaveAmtActivityInfo)_e_.getValue()));
/* 2295 */       this.level_growth_fund_activity_infos = new HashMap();
/* 2296 */       for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : _o_.level_growth_fund_activity_infos.entrySet())
/* 2297 */         this.level_growth_fund_activity_infos.put(_e_.getKey(), new LevelGrowthFundActivityInfo.Data((xbean.LevelGrowthFundActivityInfo)_e_.getValue()));
/* 2298 */       this.moth_card_activity_infos = new HashMap();
/* 2299 */       for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : _o_.moth_card_activity_infos.entrySet())
/* 2300 */         this.moth_card_activity_infos.put(_e_.getKey(), new MonthCardActivityInfo.Data((xbean.MonthCardActivityInfo)_e_.getValue()));
/* 2301 */       this.accum_total_cost_activity_infos = new HashMap();
/* 2302 */       for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : _o_.accum_total_cost_activity_infos.entrySet())
/* 2303 */         this.accum_total_cost_activity_infos.put(_e_.getKey(), new AccumTotalCostActivityInfo.Data((xbean.AccumTotalCostActivityInfo)_e_.getValue()));
/* 2304 */       this.rmb_gift_bag_activity_infos = new HashMap();
/* 2305 */       for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : _o_.rmb_gift_bag_activity_infos.entrySet())
/* 2306 */         this.rmb_gift_bag_activity_infos.put(_e_.getKey(), new RMBGiftBagActivityInfo.Data((xbean.RMBGiftBagActivityInfo)_e_.getValue()));
/* 2307 */       this.recently_cash_infos = new RecentlyCashInfo.Data(_o_.recently_cash_infos);
/* 2308 */       this.total_cash_amt = _o_.total_cash_amt;
/* 2309 */       this.inner_save_amt = _o_.inner_save_amt;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2314 */       this.appid = _o_.appid;
/* 2315 */       this.save_amt = _o_.save_amt;
/* 2316 */       this.total_cash = _o_.total_cash;
/* 2317 */       this.total_cost = _o_.total_cost;
/* 2318 */       this.total_cost_bind = _o_.total_cost_bind;
/* 2319 */       this.total_present = _o_.total_present;
/* 2320 */       this.total_present_bind = _o_.total_present_bind;
/* 2321 */       this.total_confirm_cost = _o_.total_confirm_cost;
/* 2322 */       this.total_confirm_cost_bind = _o_.total_confirm_cost_bind;
/* 2323 */       this.total_confirm_present = _o_.total_confirm_present;
/* 2324 */       this.total_confirm_present_bind = _o_.total_confirm_present_bind;
/* 2325 */       this.tss_list = _o_.tss_list;
/* 2326 */       this.tss_sum_map = new HashMap();
/* 2327 */       for (Map.Entry<String, xbean.TssSumInfo> _e_ : _o_.tss_sum_map.entrySet())
/* 2328 */         this.tss_sum_map.put(_e_.getKey(), new TssSumInfo.Data((xbean.TssSumInfo)_e_.getValue()));
/* 2329 */       this.first_recharge_status = _o_.first_recharge_status;
/* 2330 */       this.recharge_times = _o_.recharge_times;
/* 2331 */       this.statis_recharge_first_consume_status = _o_.statis_recharge_first_consume_status;
/* 2332 */       this.save_amt_activity_infos = new HashMap();
/* 2333 */       for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : _o_.save_amt_activity_infos.entrySet())
/* 2334 */         this.save_amt_activity_infos.put(_e_.getKey(), new SaveAmtActivityInfo.Data((xbean.SaveAmtActivityInfo)_e_.getValue()));
/* 2335 */       this.level_growth_fund_activity_infos = new HashMap();
/* 2336 */       for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : _o_.level_growth_fund_activity_infos.entrySet())
/* 2337 */         this.level_growth_fund_activity_infos.put(_e_.getKey(), new LevelGrowthFundActivityInfo.Data((xbean.LevelGrowthFundActivityInfo)_e_.getValue()));
/* 2338 */       this.moth_card_activity_infos = new HashMap();
/* 2339 */       for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : _o_.moth_card_activity_infos.entrySet())
/* 2340 */         this.moth_card_activity_infos.put(_e_.getKey(), new MonthCardActivityInfo.Data((xbean.MonthCardActivityInfo)_e_.getValue()));
/* 2341 */       this.accum_total_cost_activity_infos = new HashMap();
/* 2342 */       for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : _o_.accum_total_cost_activity_infos.entrySet())
/* 2343 */         this.accum_total_cost_activity_infos.put(_e_.getKey(), new AccumTotalCostActivityInfo.Data((xbean.AccumTotalCostActivityInfo)_e_.getValue()));
/* 2344 */       this.rmb_gift_bag_activity_infos = new HashMap();
/* 2345 */       for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : _o_.rmb_gift_bag_activity_infos.entrySet())
/* 2346 */         this.rmb_gift_bag_activity_infos.put(_e_.getKey(), new RMBGiftBagActivityInfo.Data((xbean.RMBGiftBagActivityInfo)_e_.getValue()));
/* 2347 */       this.recently_cash_infos = new RecentlyCashInfo.Data(_o_.recently_cash_infos);
/* 2348 */       this.total_cash_amt = _o_.total_cash_amt;
/* 2349 */       this.inner_save_amt = _o_.inner_save_amt;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2355 */       _os_.marshal(this.appid, "UTF-16LE");
/* 2356 */       _os_.marshal(this.save_amt);
/* 2357 */       _os_.marshal(this.total_cash);
/* 2358 */       _os_.marshal(this.total_cost);
/* 2359 */       _os_.marshal(this.total_cost_bind);
/* 2360 */       _os_.marshal(this.total_present);
/* 2361 */       _os_.marshal(this.total_present_bind);
/* 2362 */       _os_.marshal(this.total_confirm_cost);
/* 2363 */       _os_.marshal(this.total_confirm_cost_bind);
/* 2364 */       _os_.marshal(this.total_confirm_present);
/* 2365 */       _os_.marshal(this.total_confirm_present_bind);
/* 2366 */       _os_.marshal(this.tss_list, "UTF-16LE");
/* 2367 */       _os_.compact_uint32(this.tss_sum_map.size());
/* 2368 */       for (Map.Entry<String, xbean.TssSumInfo> _e_ : this.tss_sum_map.entrySet())
/*      */       {
/* 2370 */         _os_.marshal((String)_e_.getKey(), "UTF-16LE");
/* 2371 */         ((xbean.TssSumInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2373 */       _os_.marshal(this.first_recharge_status);
/* 2374 */       _os_.marshal(this.recharge_times);
/* 2375 */       _os_.marshal(this.statis_recharge_first_consume_status);
/* 2376 */       _os_.compact_uint32(this.save_amt_activity_infos.size());
/* 2377 */       for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : this.save_amt_activity_infos.entrySet())
/*      */       {
/* 2379 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2380 */         ((xbean.SaveAmtActivityInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2382 */       _os_.compact_uint32(this.level_growth_fund_activity_infos.size());
/* 2383 */       for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : this.level_growth_fund_activity_infos.entrySet())
/*      */       {
/* 2385 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2386 */         ((xbean.LevelGrowthFundActivityInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2388 */       _os_.compact_uint32(this.moth_card_activity_infos.size());
/* 2389 */       for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : this.moth_card_activity_infos.entrySet())
/*      */       {
/* 2391 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2392 */         ((xbean.MonthCardActivityInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2394 */       _os_.compact_uint32(this.accum_total_cost_activity_infos.size());
/* 2395 */       for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : this.accum_total_cost_activity_infos.entrySet())
/*      */       {
/* 2397 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2398 */         ((xbean.AccumTotalCostActivityInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2400 */       _os_.compact_uint32(this.rmb_gift_bag_activity_infos.size());
/* 2401 */       for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : this.rmb_gift_bag_activity_infos.entrySet())
/*      */       {
/* 2403 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2404 */         ((xbean.RMBGiftBagActivityInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2406 */       this.recently_cash_infos.marshal(_os_);
/* 2407 */       _os_.marshal(this.total_cash_amt);
/* 2408 */       _os_.marshal(this.inner_save_amt);
/* 2409 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2415 */       this.appid = _os_.unmarshal_String("UTF-16LE");
/* 2416 */       this.save_amt = _os_.unmarshal_long();
/* 2417 */       this.total_cash = _os_.unmarshal_long();
/* 2418 */       this.total_cost = _os_.unmarshal_long();
/* 2419 */       this.total_cost_bind = _os_.unmarshal_long();
/* 2420 */       this.total_present = _os_.unmarshal_long();
/* 2421 */       this.total_present_bind = _os_.unmarshal_long();
/* 2422 */       this.total_confirm_cost = _os_.unmarshal_long();
/* 2423 */       this.total_confirm_cost_bind = _os_.unmarshal_long();
/* 2424 */       this.total_confirm_present = _os_.unmarshal_long();
/* 2425 */       this.total_confirm_present_bind = _os_.unmarshal_long();
/* 2426 */       this.tss_list = _os_.unmarshal_String("UTF-16LE");
/*      */       
/* 2428 */       int size = _os_.uncompact_uint32();
/* 2429 */       if (size >= 12)
/*      */       {
/* 2431 */         this.tss_sum_map = new HashMap(size * 2);
/*      */       }
/* 2433 */       for (; size > 0; size--)
/*      */       {
/* 2435 */         String _k_ = "";
/* 2436 */         _k_ = _os_.unmarshal_String("UTF-16LE");
/* 2437 */         xbean.TssSumInfo _v_ = Pod.newTssSumInfoData();
/* 2438 */         _v_.unmarshal(_os_);
/* 2439 */         this.tss_sum_map.put(_k_, _v_);
/*      */       }
/*      */       
/* 2442 */       this.first_recharge_status = _os_.unmarshal_int();
/* 2443 */       this.recharge_times = _os_.unmarshal_int();
/* 2444 */       this.statis_recharge_first_consume_status = _os_.unmarshal_int();
/*      */       
/* 2446 */       int size = _os_.uncompact_uint32();
/* 2447 */       if (size >= 12)
/*      */       {
/* 2449 */         this.save_amt_activity_infos = new HashMap(size * 2);
/*      */       }
/* 2451 */       for (; size > 0; size--)
/*      */       {
/* 2453 */         int _k_ = 0;
/* 2454 */         _k_ = _os_.unmarshal_int();
/* 2455 */         xbean.SaveAmtActivityInfo _v_ = Pod.newSaveAmtActivityInfoData();
/* 2456 */         _v_.unmarshal(_os_);
/* 2457 */         this.save_amt_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2461 */       int size = _os_.uncompact_uint32();
/* 2462 */       if (size >= 12)
/*      */       {
/* 2464 */         this.level_growth_fund_activity_infos = new HashMap(size * 2);
/*      */       }
/* 2466 */       for (; size > 0; size--)
/*      */       {
/* 2468 */         int _k_ = 0;
/* 2469 */         _k_ = _os_.unmarshal_int();
/* 2470 */         xbean.LevelGrowthFundActivityInfo _v_ = Pod.newLevelGrowthFundActivityInfoData();
/* 2471 */         _v_.unmarshal(_os_);
/* 2472 */         this.level_growth_fund_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2476 */       int size = _os_.uncompact_uint32();
/* 2477 */       if (size >= 12)
/*      */       {
/* 2479 */         this.moth_card_activity_infos = new HashMap(size * 2);
/*      */       }
/* 2481 */       for (; size > 0; size--)
/*      */       {
/* 2483 */         int _k_ = 0;
/* 2484 */         _k_ = _os_.unmarshal_int();
/* 2485 */         xbean.MonthCardActivityInfo _v_ = Pod.newMonthCardActivityInfoData();
/* 2486 */         _v_.unmarshal(_os_);
/* 2487 */         this.moth_card_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2491 */       int size = _os_.uncompact_uint32();
/* 2492 */       if (size >= 12)
/*      */       {
/* 2494 */         this.accum_total_cost_activity_infos = new HashMap(size * 2);
/*      */       }
/* 2496 */       for (; size > 0; size--)
/*      */       {
/* 2498 */         int _k_ = 0;
/* 2499 */         _k_ = _os_.unmarshal_int();
/* 2500 */         xbean.AccumTotalCostActivityInfo _v_ = Pod.newAccumTotalCostActivityInfoData();
/* 2501 */         _v_.unmarshal(_os_);
/* 2502 */         this.accum_total_cost_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2506 */       int size = _os_.uncompact_uint32();
/* 2507 */       if (size >= 12)
/*      */       {
/* 2509 */         this.rmb_gift_bag_activity_infos = new HashMap(size * 2);
/*      */       }
/* 2511 */       for (; size > 0; size--)
/*      */       {
/* 2513 */         int _k_ = 0;
/* 2514 */         _k_ = _os_.unmarshal_int();
/* 2515 */         xbean.RMBGiftBagActivityInfo _v_ = Pod.newRMBGiftBagActivityInfoData();
/* 2516 */         _v_.unmarshal(_os_);
/* 2517 */         this.rmb_gift_bag_activity_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2520 */       this.recently_cash_infos.unmarshal(_os_);
/* 2521 */       this.total_cash_amt = _os_.unmarshal_long();
/* 2522 */       this.inner_save_amt = _os_.unmarshal_long();
/* 2523 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2529 */       int _size_ = 0;
/*      */       try
/*      */       {
/* 2532 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.appid, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2536 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2538 */       _size_ += CodedOutputStream.computeInt64Size(2, this.save_amt);
/* 2539 */       _size_ += CodedOutputStream.computeInt64Size(3, this.total_cash);
/* 2540 */       _size_ += CodedOutputStream.computeInt64Size(4, this.total_cost);
/* 2541 */       _size_ += CodedOutputStream.computeInt64Size(5, this.total_cost_bind);
/* 2542 */       _size_ += CodedOutputStream.computeInt64Size(6, this.total_present);
/* 2543 */       _size_ += CodedOutputStream.computeInt64Size(7, this.total_present_bind);
/* 2544 */       _size_ += CodedOutputStream.computeInt64Size(8, this.total_confirm_cost);
/* 2545 */       _size_ += CodedOutputStream.computeInt64Size(9, this.total_confirm_cost_bind);
/* 2546 */       _size_ += CodedOutputStream.computeInt64Size(10, this.total_confirm_present);
/* 2547 */       _size_ += CodedOutputStream.computeInt64Size(11, this.total_confirm_present_bind);
/*      */       try
/*      */       {
/* 2550 */         _size_ += CodedOutputStream.computeBytesSize(12, ByteString.copyFrom(this.tss_list, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2554 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2556 */       for (Map.Entry<String, xbean.TssSumInfo> _e_ : this.tss_sum_map.entrySet())
/*      */       {
/*      */         try
/*      */         {
/* 2560 */           _size_ += CodedOutputStream.computeBytesSize(13, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*      */         }
/*      */         catch (UnsupportedEncodingException e)
/*      */         {
/* 2564 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/* 2566 */         _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */       }
/* 2568 */       _size_ += CodedOutputStream.computeInt32Size(14, this.first_recharge_status);
/* 2569 */       _size_ += CodedOutputStream.computeInt32Size(15, this.recharge_times);
/* 2570 */       _size_ += CodedOutputStream.computeInt32Size(16, this.statis_recharge_first_consume_status);
/* 2571 */       for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : this.save_amt_activity_infos.entrySet())
/*      */       {
/* 2573 */         _size_ += CodedOutputStream.computeInt32Size(17, ((Integer)_e_.getKey()).intValue());
/* 2574 */         _size_ += CodedOutputStream.computeMessageSize(17, (Message)_e_.getValue());
/*      */       }
/* 2576 */       for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : this.level_growth_fund_activity_infos.entrySet())
/*      */       {
/* 2578 */         _size_ += CodedOutputStream.computeInt32Size(18, ((Integer)_e_.getKey()).intValue());
/* 2579 */         _size_ += CodedOutputStream.computeMessageSize(18, (Message)_e_.getValue());
/*      */       }
/* 2581 */       for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : this.moth_card_activity_infos.entrySet())
/*      */       {
/* 2583 */         _size_ += CodedOutputStream.computeInt32Size(19, ((Integer)_e_.getKey()).intValue());
/* 2584 */         _size_ += CodedOutputStream.computeMessageSize(19, (Message)_e_.getValue());
/*      */       }
/* 2586 */       for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : this.accum_total_cost_activity_infos.entrySet())
/*      */       {
/* 2588 */         _size_ += CodedOutputStream.computeInt32Size(20, ((Integer)_e_.getKey()).intValue());
/* 2589 */         _size_ += CodedOutputStream.computeMessageSize(20, (Message)_e_.getValue());
/*      */       }
/* 2591 */       for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : this.rmb_gift_bag_activity_infos.entrySet())
/*      */       {
/* 2593 */         _size_ += CodedOutputStream.computeInt32Size(21, ((Integer)_e_.getKey()).intValue());
/* 2594 */         _size_ += CodedOutputStream.computeMessageSize(21, (Message)_e_.getValue());
/*      */       }
/* 2596 */       _size_ += CodedOutputStream.computeMessageSize(22, this.recently_cash_infos);
/* 2597 */       _size_ += CodedOutputStream.computeInt64Size(23, this.total_cash_amt);
/* 2598 */       _size_ += CodedOutputStream.computeInt64Size(24, this.inner_save_amt);
/* 2599 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2607 */         _output_.writeBytes(1, ByteString.copyFrom(this.appid, "UTF-16LE"));
/* 2608 */         _output_.writeInt64(2, this.save_amt);
/* 2609 */         _output_.writeInt64(3, this.total_cash);
/* 2610 */         _output_.writeInt64(4, this.total_cost);
/* 2611 */         _output_.writeInt64(5, this.total_cost_bind);
/* 2612 */         _output_.writeInt64(6, this.total_present);
/* 2613 */         _output_.writeInt64(7, this.total_present_bind);
/* 2614 */         _output_.writeInt64(8, this.total_confirm_cost);
/* 2615 */         _output_.writeInt64(9, this.total_confirm_cost_bind);
/* 2616 */         _output_.writeInt64(10, this.total_confirm_present);
/* 2617 */         _output_.writeInt64(11, this.total_confirm_present_bind);
/* 2618 */         _output_.writeBytes(12, ByteString.copyFrom(this.tss_list, "UTF-16LE"));
/* 2619 */         for (Map.Entry<String, xbean.TssSumInfo> _e_ : this.tss_sum_map.entrySet())
/*      */         {
/* 2621 */           _output_.writeBytes(13, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/* 2622 */           _output_.writeMessage(13, (Message)_e_.getValue());
/*      */         }
/* 2624 */         _output_.writeInt32(14, this.first_recharge_status);
/* 2625 */         _output_.writeInt32(15, this.recharge_times);
/* 2626 */         _output_.writeInt32(16, this.statis_recharge_first_consume_status);
/* 2627 */         for (Map.Entry<Integer, xbean.SaveAmtActivityInfo> _e_ : this.save_amt_activity_infos.entrySet())
/*      */         {
/* 2629 */           _output_.writeInt32(17, ((Integer)_e_.getKey()).intValue());
/* 2630 */           _output_.writeMessage(17, (Message)_e_.getValue());
/*      */         }
/* 2632 */         for (Map.Entry<Integer, xbean.LevelGrowthFundActivityInfo> _e_ : this.level_growth_fund_activity_infos.entrySet())
/*      */         {
/* 2634 */           _output_.writeInt32(18, ((Integer)_e_.getKey()).intValue());
/* 2635 */           _output_.writeMessage(18, (Message)_e_.getValue());
/*      */         }
/* 2637 */         for (Map.Entry<Integer, xbean.MonthCardActivityInfo> _e_ : this.moth_card_activity_infos.entrySet())
/*      */         {
/* 2639 */           _output_.writeInt32(19, ((Integer)_e_.getKey()).intValue());
/* 2640 */           _output_.writeMessage(19, (Message)_e_.getValue());
/*      */         }
/* 2642 */         for (Map.Entry<Integer, xbean.AccumTotalCostActivityInfo> _e_ : this.accum_total_cost_activity_infos.entrySet())
/*      */         {
/* 2644 */           _output_.writeInt32(20, ((Integer)_e_.getKey()).intValue());
/* 2645 */           _output_.writeMessage(20, (Message)_e_.getValue());
/*      */         }
/* 2647 */         for (Map.Entry<Integer, xbean.RMBGiftBagActivityInfo> _e_ : this.rmb_gift_bag_activity_infos.entrySet())
/*      */         {
/* 2649 */           _output_.writeInt32(21, ((Integer)_e_.getKey()).intValue());
/* 2650 */           _output_.writeMessage(21, (Message)_e_.getValue());
/*      */         }
/* 2652 */         _output_.writeMessage(22, this.recently_cash_infos);
/* 2653 */         _output_.writeInt64(23, this.total_cash_amt);
/* 2654 */         _output_.writeInt64(24, this.inner_save_amt);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2658 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2660 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2668 */         boolean done = false;
/* 2669 */         while (!done)
/*      */         {
/* 2671 */           int tag = _input_.readTag();
/* 2672 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2676 */             done = true;
/* 2677 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 2681 */             this.appid = _input_.readBytes().toString("UTF-16LE");
/* 2682 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2686 */             this.save_amt = _input_.readInt64();
/* 2687 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2691 */             this.total_cash = _input_.readInt64();
/* 2692 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2696 */             this.total_cost = _input_.readInt64();
/* 2697 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2701 */             this.total_cost_bind = _input_.readInt64();
/* 2702 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2706 */             this.total_present = _input_.readInt64();
/* 2707 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2711 */             this.total_present_bind = _input_.readInt64();
/* 2712 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2716 */             this.total_confirm_cost = _input_.readInt64();
/* 2717 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 2721 */             this.total_confirm_cost_bind = _input_.readInt64();
/* 2722 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2726 */             this.total_confirm_present = _input_.readInt64();
/* 2727 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2731 */             this.total_confirm_present_bind = _input_.readInt64();
/* 2732 */             break;
/*      */           
/*      */ 
/*      */           case 98: 
/* 2736 */             this.tss_list = _input_.readBytes().toString("UTF-16LE");
/* 2737 */             break;
/*      */           
/*      */ 
/*      */           case 106: 
/* 2741 */             String _k_ = "";
/* 2742 */             _k_ = _input_.readBytes().toString("UTF-16LE");
/* 2743 */             int readTag = _input_.readTag();
/* 2744 */             if (106 != readTag)
/*      */             {
/* 2746 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2748 */             xbean.TssSumInfo _v_ = Pod.newTssSumInfoData();
/* 2749 */             _input_.readMessage(_v_);
/* 2750 */             this.tss_sum_map.put(_k_, _v_);
/* 2751 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 2755 */             this.first_recharge_status = _input_.readInt32();
/* 2756 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 2760 */             this.recharge_times = _input_.readInt32();
/* 2761 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 2765 */             this.statis_recharge_first_consume_status = _input_.readInt32();
/* 2766 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 2770 */             int _k_ = 0;
/* 2771 */             _k_ = _input_.readInt32();
/* 2772 */             int readTag = _input_.readTag();
/* 2773 */             if (138 != readTag)
/*      */             {
/* 2775 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2777 */             xbean.SaveAmtActivityInfo _v_ = Pod.newSaveAmtActivityInfoData();
/* 2778 */             _input_.readMessage(_v_);
/* 2779 */             this.save_amt_activity_infos.put(Integer.valueOf(_k_), _v_);
/* 2780 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2784 */             int _k_ = 0;
/* 2785 */             _k_ = _input_.readInt32();
/* 2786 */             int readTag = _input_.readTag();
/* 2787 */             if (146 != readTag)
/*      */             {
/* 2789 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2791 */             xbean.LevelGrowthFundActivityInfo _v_ = Pod.newLevelGrowthFundActivityInfoData();
/* 2792 */             _input_.readMessage(_v_);
/* 2793 */             this.level_growth_fund_activity_infos.put(Integer.valueOf(_k_), _v_);
/* 2794 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 2798 */             int _k_ = 0;
/* 2799 */             _k_ = _input_.readInt32();
/* 2800 */             int readTag = _input_.readTag();
/* 2801 */             if (154 != readTag)
/*      */             {
/* 2803 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2805 */             xbean.MonthCardActivityInfo _v_ = Pod.newMonthCardActivityInfoData();
/* 2806 */             _input_.readMessage(_v_);
/* 2807 */             this.moth_card_activity_infos.put(Integer.valueOf(_k_), _v_);
/* 2808 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 2812 */             int _k_ = 0;
/* 2813 */             _k_ = _input_.readInt32();
/* 2814 */             int readTag = _input_.readTag();
/* 2815 */             if (162 != readTag)
/*      */             {
/* 2817 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2819 */             xbean.AccumTotalCostActivityInfo _v_ = Pod.newAccumTotalCostActivityInfoData();
/* 2820 */             _input_.readMessage(_v_);
/* 2821 */             this.accum_total_cost_activity_infos.put(Integer.valueOf(_k_), _v_);
/* 2822 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 2826 */             int _k_ = 0;
/* 2827 */             _k_ = _input_.readInt32();
/* 2828 */             int readTag = _input_.readTag();
/* 2829 */             if (170 != readTag)
/*      */             {
/* 2831 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2833 */             xbean.RMBGiftBagActivityInfo _v_ = Pod.newRMBGiftBagActivityInfoData();
/* 2834 */             _input_.readMessage(_v_);
/* 2835 */             this.rmb_gift_bag_activity_infos.put(Integer.valueOf(_k_), _v_);
/* 2836 */             break;
/*      */           
/*      */ 
/*      */           case 178: 
/* 2840 */             _input_.readMessage(this.recently_cash_infos);
/* 2841 */             break;
/*      */           
/*      */ 
/*      */           case 184: 
/* 2845 */             this.total_cash_amt = _input_.readInt64();
/* 2846 */             break;
/*      */           
/*      */ 
/*      */           case 192: 
/* 2850 */             this.inner_save_amt = _input_.readInt64();
/* 2851 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2855 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2857 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2866 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2870 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2872 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QingfuInfo copy()
/*      */     {
/* 2878 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QingfuInfo toData()
/*      */     {
/* 2884 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.QingfuInfo toBean()
/*      */     {
/* 2889 */       return new QingfuInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QingfuInfo toDataIf()
/*      */     {
/* 2895 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.QingfuInfo toBeanIf()
/*      */     {
/* 2900 */       return new QingfuInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2906 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2910 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2914 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2918 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2922 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2926 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2930 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAppid()
/*      */     {
/* 2937 */       return this.appid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAppidOctets()
/*      */     {
/* 2944 */       return Octets.wrap(getAppid(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSave_amt()
/*      */     {
/* 2951 */       return this.save_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cash()
/*      */     {
/* 2958 */       return this.total_cash;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cost()
/*      */     {
/* 2965 */       return this.total_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cost_bind()
/*      */     {
/* 2972 */       return this.total_cost_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_present()
/*      */     {
/* 2979 */       return this.total_present;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_present_bind()
/*      */     {
/* 2986 */       return this.total_present_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_cost()
/*      */     {
/* 2993 */       return this.total_confirm_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_cost_bind()
/*      */     {
/* 3000 */       return this.total_confirm_cost_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_present()
/*      */     {
/* 3007 */       return this.total_confirm_present;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_confirm_present_bind()
/*      */     {
/* 3014 */       return this.total_confirm_present_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getTss_list()
/*      */     {
/* 3021 */       return this.tss_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getTss_listOctets()
/*      */     {
/* 3028 */       return Octets.wrap(getTss_list(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, xbean.TssSumInfo> getTss_sum_map()
/*      */     {
/* 3035 */       return this.tss_sum_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, xbean.TssSumInfo> getTss_sum_mapAsData()
/*      */     {
/* 3042 */       return this.tss_sum_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFirst_recharge_status()
/*      */     {
/* 3049 */       return this.first_recharge_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecharge_times()
/*      */     {
/* 3056 */       return this.recharge_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatis_recharge_first_consume_status()
/*      */     {
/* 3063 */       return this.statis_recharge_first_consume_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SaveAmtActivityInfo> getSave_amt_activity_infos()
/*      */     {
/* 3070 */       return this.save_amt_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SaveAmtActivityInfo> getSave_amt_activity_infosAsData()
/*      */     {
/* 3077 */       return this.save_amt_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infos()
/*      */     {
/* 3084 */       return this.level_growth_fund_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infosAsData()
/*      */     {
/* 3091 */       return this.level_growth_fund_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MonthCardActivityInfo> getMoth_card_activity_infos()
/*      */     {
/* 3098 */       return this.moth_card_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.MonthCardActivityInfo> getMoth_card_activity_infosAsData()
/*      */     {
/* 3105 */       return this.moth_card_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AccumTotalCostActivityInfo> getAccum_total_cost_activity_infos()
/*      */     {
/* 3112 */       return this.accum_total_cost_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AccumTotalCostActivityInfo> getAccum_total_cost_activity_infosAsData()
/*      */     {
/* 3119 */       return this.accum_total_cost_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infos()
/*      */     {
/* 3126 */       return this.rmb_gift_bag_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infosAsData()
/*      */     {
/* 3133 */       return this.rmb_gift_bag_activity_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RecentlyCashInfo getRecently_cash_infos()
/*      */     {
/* 3140 */       return this.recently_cash_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotal_cash_amt()
/*      */     {
/* 3147 */       return this.total_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInner_save_amt()
/*      */     {
/* 3154 */       return this.inner_save_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAppid(String _v_)
/*      */     {
/* 3161 */       if (null == _v_)
/* 3162 */         throw new NullPointerException();
/* 3163 */       this.appid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAppidOctets(Octets _v_)
/*      */     {
/* 3170 */       setAppid(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSave_amt(long _v_)
/*      */     {
/* 3177 */       this.save_amt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cash(long _v_)
/*      */     {
/* 3184 */       this.total_cash = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cost(long _v_)
/*      */     {
/* 3191 */       this.total_cost = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cost_bind(long _v_)
/*      */     {
/* 3198 */       this.total_cost_bind = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_present(long _v_)
/*      */     {
/* 3205 */       this.total_present = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_present_bind(long _v_)
/*      */     {
/* 3212 */       this.total_present_bind = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_cost(long _v_)
/*      */     {
/* 3219 */       this.total_confirm_cost = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_cost_bind(long _v_)
/*      */     {
/* 3226 */       this.total_confirm_cost_bind = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_present(long _v_)
/*      */     {
/* 3233 */       this.total_confirm_present = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_confirm_present_bind(long _v_)
/*      */     {
/* 3240 */       this.total_confirm_present_bind = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTss_list(String _v_)
/*      */     {
/* 3247 */       if (null == _v_)
/* 3248 */         throw new NullPointerException();
/* 3249 */       this.tss_list = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTss_listOctets(Octets _v_)
/*      */     {
/* 3256 */       setTss_list(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirst_recharge_status(int _v_)
/*      */     {
/* 3263 */       this.first_recharge_status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecharge_times(int _v_)
/*      */     {
/* 3270 */       this.recharge_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatis_recharge_first_consume_status(int _v_)
/*      */     {
/* 3277 */       this.statis_recharge_first_consume_status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_cash_amt(long _v_)
/*      */     {
/* 3284 */       this.total_cash_amt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInner_save_amt(long _v_)
/*      */     {
/* 3291 */       this.inner_save_amt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3297 */       if (!(_o1_ instanceof Data)) return false;
/* 3298 */       Data _o_ = (Data)_o1_;
/* 3299 */       if (!this.appid.equals(_o_.appid)) return false;
/* 3300 */       if (this.save_amt != _o_.save_amt) return false;
/* 3301 */       if (this.total_cash != _o_.total_cash) return false;
/* 3302 */       if (this.total_cost != _o_.total_cost) return false;
/* 3303 */       if (this.total_cost_bind != _o_.total_cost_bind) return false;
/* 3304 */       if (this.total_present != _o_.total_present) return false;
/* 3305 */       if (this.total_present_bind != _o_.total_present_bind) return false;
/* 3306 */       if (this.total_confirm_cost != _o_.total_confirm_cost) return false;
/* 3307 */       if (this.total_confirm_cost_bind != _o_.total_confirm_cost_bind) return false;
/* 3308 */       if (this.total_confirm_present != _o_.total_confirm_present) return false;
/* 3309 */       if (this.total_confirm_present_bind != _o_.total_confirm_present_bind) return false;
/* 3310 */       if (!this.tss_list.equals(_o_.tss_list)) return false;
/* 3311 */       if (!this.tss_sum_map.equals(_o_.tss_sum_map)) return false;
/* 3312 */       if (this.first_recharge_status != _o_.first_recharge_status) return false;
/* 3313 */       if (this.recharge_times != _o_.recharge_times) return false;
/* 3314 */       if (this.statis_recharge_first_consume_status != _o_.statis_recharge_first_consume_status) return false;
/* 3315 */       if (!this.save_amt_activity_infos.equals(_o_.save_amt_activity_infos)) return false;
/* 3316 */       if (!this.level_growth_fund_activity_infos.equals(_o_.level_growth_fund_activity_infos)) return false;
/* 3317 */       if (!this.moth_card_activity_infos.equals(_o_.moth_card_activity_infos)) return false;
/* 3318 */       if (!this.accum_total_cost_activity_infos.equals(_o_.accum_total_cost_activity_infos)) return false;
/* 3319 */       if (!this.rmb_gift_bag_activity_infos.equals(_o_.rmb_gift_bag_activity_infos)) return false;
/* 3320 */       if (!this.recently_cash_infos.equals(_o_.recently_cash_infos)) return false;
/* 3321 */       if (this.total_cash_amt != _o_.total_cash_amt) return false;
/* 3322 */       if (this.inner_save_amt != _o_.inner_save_amt) return false;
/* 3323 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3329 */       int _h_ = 0;
/* 3330 */       _h_ += this.appid.hashCode();
/* 3331 */       _h_ = (int)(_h_ + this.save_amt);
/* 3332 */       _h_ = (int)(_h_ + this.total_cash);
/* 3333 */       _h_ = (int)(_h_ + this.total_cost);
/* 3334 */       _h_ = (int)(_h_ + this.total_cost_bind);
/* 3335 */       _h_ = (int)(_h_ + this.total_present);
/* 3336 */       _h_ = (int)(_h_ + this.total_present_bind);
/* 3337 */       _h_ = (int)(_h_ + this.total_confirm_cost);
/* 3338 */       _h_ = (int)(_h_ + this.total_confirm_cost_bind);
/* 3339 */       _h_ = (int)(_h_ + this.total_confirm_present);
/* 3340 */       _h_ = (int)(_h_ + this.total_confirm_present_bind);
/* 3341 */       _h_ += this.tss_list.hashCode();
/* 3342 */       _h_ += this.tss_sum_map.hashCode();
/* 3343 */       _h_ += this.first_recharge_status;
/* 3344 */       _h_ += this.recharge_times;
/* 3345 */       _h_ += this.statis_recharge_first_consume_status;
/* 3346 */       _h_ += this.save_amt_activity_infos.hashCode();
/* 3347 */       _h_ += this.level_growth_fund_activity_infos.hashCode();
/* 3348 */       _h_ += this.moth_card_activity_infos.hashCode();
/* 3349 */       _h_ += this.accum_total_cost_activity_infos.hashCode();
/* 3350 */       _h_ += this.rmb_gift_bag_activity_infos.hashCode();
/* 3351 */       _h_ += this.recently_cash_infos.hashCode();
/* 3352 */       _h_ = (int)(_h_ + this.total_cash_amt);
/* 3353 */       _h_ = (int)(_h_ + this.inner_save_amt);
/* 3354 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3360 */       StringBuilder _sb_ = new StringBuilder();
/* 3361 */       _sb_.append("(");
/* 3362 */       _sb_.append("'").append(this.appid).append("'");
/* 3363 */       _sb_.append(",");
/* 3364 */       _sb_.append(this.save_amt);
/* 3365 */       _sb_.append(",");
/* 3366 */       _sb_.append(this.total_cash);
/* 3367 */       _sb_.append(",");
/* 3368 */       _sb_.append(this.total_cost);
/* 3369 */       _sb_.append(",");
/* 3370 */       _sb_.append(this.total_cost_bind);
/* 3371 */       _sb_.append(",");
/* 3372 */       _sb_.append(this.total_present);
/* 3373 */       _sb_.append(",");
/* 3374 */       _sb_.append(this.total_present_bind);
/* 3375 */       _sb_.append(",");
/* 3376 */       _sb_.append(this.total_confirm_cost);
/* 3377 */       _sb_.append(",");
/* 3378 */       _sb_.append(this.total_confirm_cost_bind);
/* 3379 */       _sb_.append(",");
/* 3380 */       _sb_.append(this.total_confirm_present);
/* 3381 */       _sb_.append(",");
/* 3382 */       _sb_.append(this.total_confirm_present_bind);
/* 3383 */       _sb_.append(",");
/* 3384 */       _sb_.append("'").append(this.tss_list).append("'");
/* 3385 */       _sb_.append(",");
/* 3386 */       _sb_.append(this.tss_sum_map);
/* 3387 */       _sb_.append(",");
/* 3388 */       _sb_.append(this.first_recharge_status);
/* 3389 */       _sb_.append(",");
/* 3390 */       _sb_.append(this.recharge_times);
/* 3391 */       _sb_.append(",");
/* 3392 */       _sb_.append(this.statis_recharge_first_consume_status);
/* 3393 */       _sb_.append(",");
/* 3394 */       _sb_.append(this.save_amt_activity_infos);
/* 3395 */       _sb_.append(",");
/* 3396 */       _sb_.append(this.level_growth_fund_activity_infos);
/* 3397 */       _sb_.append(",");
/* 3398 */       _sb_.append(this.moth_card_activity_infos);
/* 3399 */       _sb_.append(",");
/* 3400 */       _sb_.append(this.accum_total_cost_activity_infos);
/* 3401 */       _sb_.append(",");
/* 3402 */       _sb_.append(this.rmb_gift_bag_activity_infos);
/* 3403 */       _sb_.append(",");
/* 3404 */       _sb_.append(this.recently_cash_infos);
/* 3405 */       _sb_.append(",");
/* 3406 */       _sb_.append(this.total_cash_amt);
/* 3407 */       _sb_.append(",");
/* 3408 */       _sb_.append(this.inner_save_amt);
/* 3409 */       _sb_.append(")");
/* 3410 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\QingfuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */